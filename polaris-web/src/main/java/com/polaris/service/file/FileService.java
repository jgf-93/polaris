package com.polaris.service.file;

import com.polaris.common.entity.FileUploadRecord;
import com.polaris.common.mapper.FileUploadRecordMapper;
import com.polaris.common.oss.OssClientFactory;
import com.polaris.common.oss.OssUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    public static String ossPath = "/video/UUID";

    @Resource
    private OssUtils ossUtils;
    @Resource
    private FileUploadRecordMapper fileUploadRecordMapper;

    public void videoUploadPart(MultipartFile multipartFile) throws Exception {
        String filePath = ossPath.replace("UUID", UUID.randomUUID().toString()) + "-video.mp4";
        String uploadId = ossUtils.partUpload("video", filePath, multipartFile.getSize(), multipartFile.getInputStream());
        if (!StringUtils.isEmpty(uploadId)) {
            FileUploadRecord fileUploadRecord = new FileUploadRecord();
            fileUploadRecord.setUploadId(uploadId);
            fileUploadRecord.setName("视频上传");
            fileUploadRecord.setType(FileUploadRecord.UploadType.part);
            fileUploadRecord.setUrl(filePath);
            fileUploadRecordMapper.insert(fileUploadRecord);
        }
    }
}
