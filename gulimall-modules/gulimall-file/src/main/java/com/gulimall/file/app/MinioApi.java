package com.gulimall.file.app;

import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.file.domain.MinioDTO;
import com.gulimall.file.utils.MinioUtils;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author gwoksing
 * @date 2022/5/26 16:09
 */
@RestController
@RequestMapping("/api/minio")
public class MinioApi extends BaseController {
    @Autowired
    private MinioUtils minIoUtils;

    @PostMapping("/upload")
    public AjaxResult upload(MultipartFile file, String path) {
        return AjaxResult.success(minIoUtils.upload(file, path));
    }

    @PostMapping("/putObjectStream")
    public AjaxResult putObjectStream(String objectName, InputStream inputStream, Long fileSize, String path, String contentType) {
        return AjaxResult.success(minIoUtils.putObjectStream(objectName, inputStream, fileSize, path, contentType));
    }

    @GetMapping("/download")
    public void download(@RequestParam String filepath, HttpServletResponse response) {
        minIoUtils.download(filepath, response);
    }

    @PostMapping("/remove")
    public AjaxResult removeObj(@RequestBody MinioDTO minioDTO) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return minIoUtils.removeObject(minioDTO.getObjName());
    }
}
