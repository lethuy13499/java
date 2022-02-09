package com.jungdo.service;

import com.jungdo.Domain.DownloadFileRequest;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

public interface FileService {
    Boolean uploadFiles(MultipartFile[] multipartFiles);

    byte[] downloadFile(DownloadFileRequest downloadFileRequest);

    URL getImageUrl(String imageName);
}
