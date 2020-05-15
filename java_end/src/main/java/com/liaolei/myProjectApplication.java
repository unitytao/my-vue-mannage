package com.liaolei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liaolei.mapper")
public class myProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(myProjectApplication.class,args);
    }
}
