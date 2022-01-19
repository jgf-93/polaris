package com.polaris.common.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.internal.OSSHeaders;
import com.aliyun.oss.model.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class OssUtils {
    @Resource
    private OssClientFactory ossClientFactory;

    public void createBucket(String bucketName) {
        // 创建CreateBucketRequest对象。
        CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
        // 如果创建存储空间的同时需要指定存储类型以及数据容灾类型, 可以参考以下代码。
        // 此处以设置存储空间的存储类型为标准存储为例。
        // createBucketRequest.setStorageClass(StorageClass.Standard);
        // 默认情况下，数据容灾类型为本地冗余存储，即DataRedundancyType.LRS。如果需要设置数据容灾类型为同城冗余存储，请替换为DataRedundancyType.ZRS。
        // createBucketRequest.setDataRedundancyType(DataRedundancyType.ZRS)

        // 创建存储空间。
        ossClientFactory.getOssClient().createBucket(createBucketRequest);
    }

    //列举存储空间
    public List<Bucket> listBuckets() {
        return ossClientFactory.getOssClient().listBuckets();
    }

    //判断是否存在存储空间
    public Boolean doesBucketExist(String bucket) {
        return ossClientFactory.getOssClient().doesBucketExist(bucket);
    }

    //简单上传
    public void upload(File file, String filePath) {
        PutObjectRequest ufr = new PutObjectRequest("video", filePath, file);
        // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        metadata.setObjectAcl(CannedAccessControlList.Private);
        ufr.setMetadata(metadata);
        try {
            ossClientFactory.getOssClient().putObject(ufr);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            ossClientFactory.getOssClient().shutdown();
        }
    }

    //分片上传
    public String partUpload(String bucketName, String filePath, long fileLength, InputStream inputStream) throws IOException {
        OSS oss = ossClientFactory.getOssClient();
        try {
            //初始化一个分片上传事件。
            InitiateMultipartUploadRequest impu = new InitiateMultipartUploadRequest(bucketName, filePath);
            // 如果需要在初始化分片时设置文件存储类型，请参考以下示例代码。
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            impu.setObjectMetadata(metadata);
            InitiateMultipartUploadResult initiateMultipartUploadResult = oss.initiateMultipartUpload(impu);
            //返回uploadId，它是分片上传事件的唯一标识，您可以根据这个ID来发起相关的操作，如取消分片上传、查询分片上传等。
            String uploadId = initiateMultipartUploadResult.getUploadId();
            //计算分片上传的内容
            List<PartETag> partETagList = new ArrayList<>();
            long partSize = 1024 * 1024l;//1mb
            int count = (int) (fileLength / partSize);
            count = (fileLength % partSize != 0) ? count : count++;
            for (int i = 0; i < count; i++) {
                //分片起始位置
                long startPos = i * partSize;
                //分片大小
                long currentPartSize = (i + 1 == count) ? (fileLength - startPos) : partSize;
                inputStream.skip(startPos);
                UploadPartRequest uploadPartRequest = new UploadPartRequest();
                uploadPartRequest.setUploadId(uploadId);
                uploadPartRequest.setBucketName(bucketName);
                uploadPartRequest.setInputStream(inputStream);
                uploadPartRequest.setKey(filePath);
                uploadPartRequest.setPartSize(currentPartSize);
                uploadPartRequest.setPartNumber(i + 1);
                // 每个分片不需要按顺序上传，甚至可以在不同客户端上传，OSS会按照分片号排序组成完整的文件。
                UploadPartResult uploadPartResult = oss.uploadPart(uploadPartRequest);
                // 每次上传分片之后，OSS的返回结果会包含一个PartETag。PartETag将被保存到partETags中。
                partETagList.add(uploadPartResult.getPartETag());
            }
            // 创建CompleteMultipartUploadRequest对象。
            // 在执行完成分片上传操作时，需要提供所有有效的partETags。OSS收到提交的partETags后，
            // 会逐一验证每个分片的有效性。当所有的数据分片验证通过后，OSS将把这些分片组合成一个完整的文件。
            CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(bucketName, filePath, uploadId, partETagList);
            // 如果需要在完成文件上传的同时设置文件访问权限，请参考以下示例代码。
            completeMultipartUploadRequest.setObjectACL(CannedAccessControlList.PublicRead);
            CompleteMultipartUploadResult completeMultipartUploadResult = oss.completeMultipartUpload(completeMultipartUploadRequest);
            return uploadId;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            oss.shutdown();
        }
        return "";
    }
}
