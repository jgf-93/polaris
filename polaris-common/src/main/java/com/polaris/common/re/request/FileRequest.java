package com.polaris.common.re.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileRequest {
    private MultipartFile multipartFile;
}
