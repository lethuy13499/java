package com.jungdo.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import com.jungdo.Domain.DownloadFileRequest;
import com.jungdo.exception.BusinessException;
import com.jungdo.io.MinioStorageProperties;
import com.jungdo.service.FileService;
import com.jungdo.utils.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private MinioStorageProperties minioProperties;
    @Autowired
    private AmazonS3 amazonS3;

    private static final Object lock = new Object();


    @Override
    public Boolean uploadFiles(MultipartFile[] multipartFiles) {
        for (MultipartFile file : multipartFiles) {
            saveFile("", "images/".concat(file.getOriginalFilename()), file);
        }
        return true;
    }

    @Override
    public byte[] downloadFile(DownloadFileRequest downloadFileRequest) {
        return new byte[0];
    }

    @Override
    public URL getImageUrl(String imageName) {
        if (!StringUtils.hasLength(imageName)) {
            return null;
        }
        String bucketName = minioProperties.getBucketNamePrefix();
        String fileName = "images/".concat(imageName);
        if (!amazonS3.doesObjectExist(bucketName, fileName)) {
            throw new BusinessException("");
        }
        try {
            return amazonS3.generatePresignedUrl(bucketName, fileName, DateTimeUtils.addMinutesToDate(new Date(), 5));
        } catch (Exception ex) {
            throw new BusinessException("");
        }
    }

    private byte[] getFile(String bucketName, String fileName) {
        bucketName = minioProperties.getBucketNamePrefix().concat(bucketName);
        if (!amazonS3.doesObjectExist(bucketName, fileName)) {
            throw new BusinessException("");
        }
        try {
            GetObjectRequest rangeObjectRequest = new GetObjectRequest(bucketName, fileName);
            S3Object s3Object = amazonS3.getObject(rangeObjectRequest);
            S3ObjectInputStream inputStream = s3Object.getObjectContent();
            return IOUtils.toByteArray(inputStream);
        } catch (Exception ex) {
            throw new BusinessException("");
        }
    }

    private boolean saveFile(String bucketName, String fileName, MultipartFile file) {
        try {
            byte[] contents = file.getBytes();
            String contentType = file.getContentType();
            bucketName = minioProperties.getBucketNamePrefix().concat(bucketName);
            if (!amazonS3.doesBucketExist(bucketName)) {
                synchronized (lock) {
                    if (!amazonS3.doesBucketExist(bucketName)) {
                        amazonS3.createBucket(bucketName);
                    }
                }
            }
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(contentType);
            InputStream inputStream = new ByteArrayInputStream(contents);
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, inputStream, metadata);
            amazonS3.putObject(putObjectRequest);
            return true;
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
        }
        return false;
    }

}

