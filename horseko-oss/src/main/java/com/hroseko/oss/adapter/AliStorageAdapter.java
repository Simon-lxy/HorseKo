package com.hroseko.oss.adapter;

import com.hroseko.oss.entity.FileInfo;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * @author Wayne
 * @data 2024/03/22 16:42:12
 **/
public class AliStorageAdapter implements StorageAdapter{


    @SneakyThrows
    @Override
    public void createBucket(String bucket) {

    }

    @SneakyThrows
    @Override
    public void uploadFile(MultipartFile uploadFile, String bucket, String objectName) {

    }

    @SneakyThrows
    @Override
    public List<String> getAllBucket() {
        return null;
    }

    @SneakyThrows
    @Override
    public List<FileInfo> getAllFile(String bucket) {
        return null;
    }

    @SneakyThrows
    @Override
    public InputStream downLoad(String bucket, String objectName) {
        return null;
    }

    @SneakyThrows
    @Override
    public void deleteBucket(String bucket) {

    }

    @SneakyThrows
    @Override
    public void deleteObject(String bucket, String objectName) {

    }

    @SneakyThrows
    @Override
    public String getUrl(String bucket, String objectName) {
        return null;
    }
}
