package com.horseko.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 网关启动器
 *
 * @author Wayne
 * @data 2024/03/23 12:52:28
 **/
@SpringBootApplication
@ComponentScan("com.horseko")
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class);
    }
}
