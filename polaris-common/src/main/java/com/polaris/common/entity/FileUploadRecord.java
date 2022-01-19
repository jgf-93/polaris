package com.polaris.common.entity;

import lombok.Data;

@Data
public class FileUploadRecord extends BaseEntity {
    private long id;
    private UploadType type;
    private String name;
    private String url;
    private String uploadId;

    public enum UploadType {
        part("分片上传"),
        easy("简单上传");

        private String name;

        UploadType(String name) {
            this.name = name;
        }
    }
}
