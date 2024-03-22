package com.hroseko.oss.config;

import com.hroseko.oss.adapter.AliStorageAdapter;
import com.hroseko.oss.adapter.MinioStorageAdapter;
import com.hroseko.oss.adapter.StorageAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Wayne
 * @data 2024/03/22 16:34:55
 **/
@Configuration
public class StorageConfig {

    @Value("${storage.service.type}")
    private String storageType;

    @Bean
    @RefreshScope
    public StorageAdapter storageAdapter() {
        if ("minio".equals(storageType)) {
            return new MinioStorageAdapter();
        } else if ("aliyun".equals(storageType)) {
            return new AliStorageAdapter();
        } else {
            throw new IllegalArgumentException("未找到对应的文件存储器");
        }
    }
}
