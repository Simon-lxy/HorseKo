package com.hroseko.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Wayne
 * @data 2024/03/20 16:04:49
 * 1
 **/
@SpringBootApplication
@ComponentScan("com.hroseko")
public class OssApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class);
    }
}
