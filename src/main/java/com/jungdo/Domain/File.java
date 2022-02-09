package com.jungdo.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class File implements Serializable {
    private String path;
    private String filename;
    private String fileCode;
    private String fileUrl;
    @JsonIgnore
    private byte[] contents;
    private String contentType;
    private long size;
    private String createDate;

    public File(String path, String filename, String fileUrl, String contentType, String createDate) {
        this.path = path;
        this.filename = filename;
        this.fileUrl = fileUrl;
        this.contentType = contentType;
        this.createDate = createDate;
    }

}
