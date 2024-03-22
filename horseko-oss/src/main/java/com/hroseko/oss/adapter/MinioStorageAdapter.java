package com.hroseko.oss.adapter;

import com.hroseko.oss.entity.FileInfo;
import com.hroseko.oss.util.MinioUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

/**
 * minioIO存储适配器
 *
 * @author Wayne
 * @data 2024/03/20 16:34:24
 **/
public class MinioStorageAdapter implements StorageAdapter{

    @Resource
    private MinioUtil minioUtil;

    /**
     * minio Url
     */
    @Value("${minio.url}")
    private String url;

    @SneakyThrows
    @Override
    public void createBucket(String bucket) {
        minioUtil.createBucket(bucket);
    }

    @SneakyThrows
    @Override
    public void uploadFile(MultipartFile uploadFile, String bucket, String objectName) {
        minioUtil.createBucket(bucket);
        if (objectName != null) {
            minioUtil.uploadFile(uploadFile.getInputStream(), bucket,  objectName + "/" + uploadFile.getOriginalFilename());
        } else {
            minioUtil.uploadFile(uploadFile.getInputStream(), bucket, uploadFile.getOriginalFilename());
        }
    }

    @SneakyThrows
    @Override
    public List<String> getAllBucket() {
        return minioUtil.getAllBucket();
    }

    @SneakyThrows
    @Override
    public List<FileInfo> getAllFile(String bucket) {
        return minioUtil.getAllFile(bucket);
    }

    @SneakyThrows
    @Override
    public InputStream downLoad(String bucket, String objectName) {
        return minioUtil.downLoad(bucket, objectName);
    }

    @SneakyThrows
    @Override
    public void deleteBucket(String bucket) {
        minioUtil.deleteBucket(bucket);
    }

    @SneakyThrows
    @Override
    public void deleteObject(String bucket, String objectName) {
        minioUtil.deleteObject(bucket, objectName);
    }

    @SneakyThrows
    @Override
    public String getUrl(String bucket, String objectName) {
        return url + "/" + bucket + "/" + objectName;
    }
}
