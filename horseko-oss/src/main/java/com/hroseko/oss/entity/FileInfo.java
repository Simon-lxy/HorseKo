package com.hroseko.oss.entity;

import lombok.Data;

/**
 * 文件类
 *
 * @author Wayne
 * @data 2024/03/20 16:25:14
 *
 * 4
 **/
@Data
public class FileInfo {

    private String fileName;

    private Boolean directoryFlag;

    private String etag;
}
