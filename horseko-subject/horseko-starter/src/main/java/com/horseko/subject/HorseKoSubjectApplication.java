package com.horseko.subject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Wayne
 * @data 2024/03/09 22:13:03
 **/
@SpringBootApplication
@ComponentScan("com.horseko")
@MapperScan("com.horseko.**.mapper")
public class HorseKoSubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(HorseKoSubjectApplication.class);
    }
}
