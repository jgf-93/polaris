package com.polaris.controller.file;

import com.polaris.common.re.BaseResponse;
import com.polaris.common.re.request.FileRequest;
import com.polaris.service.file.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/file")
public class FileController {
    @Resource
    private FileService fileService;

    @RequestMapping("videoUploadPart")
    public BaseResponse videoUploadPart(FileRequest request) throws Exception {
/*
        fileService.videoUploadPart(request.getMultipartFile());
*/
        return BaseResponse.buildSuccessResponse();
    }
}
