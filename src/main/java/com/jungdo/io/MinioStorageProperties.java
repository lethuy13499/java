package com.jungdo.io;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "storage")
@Data
public class MinioStorageProperties {
    private String accessKey;
    private String secretKey;
    private String endpoint;
    private long expire;
    private String bucketNamePrefix;
}
