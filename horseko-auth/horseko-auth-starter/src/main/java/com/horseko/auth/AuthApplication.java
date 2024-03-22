package com.horseko.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Wayne
 * @data 2024/03/22 19:59:22
 **/
@SpringBootApplication
@ComponentScan("com.horseko")
@MapperScan("com.horseko.**.mapper")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class);
    }
}
