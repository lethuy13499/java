package com.jungdo.controller;

import com.jungdo.common.AppResponseEntity;
import com.jungdo.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @PostMapping("/upload-files")
    public AppResponseEntity<?> uploadFiles(@RequestPart("files") MultipartFile[] multipartFile) {
        return AppResponseEntity.withSuccess(fileService.uploadFiles(multipartFile));
    }

    @GetMapping("/url")
    public AppResponseEntity<URL> getImageUrl(@RequestParam String fileName) {
        return AppResponseEntity.withSuccess(fileService.getImageUrl(fileName));
    }
}
