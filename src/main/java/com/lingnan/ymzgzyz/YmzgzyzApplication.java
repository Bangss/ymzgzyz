package com.lingnan.ymzgzyz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lingnan.ymzgzyz.mapper")
@SpringBootApplication
public class YmzgzyzApplication {

    public static void main ( String[] args ) {
        SpringApplication.run(YmzgzyzApplication.class, args);
    }

}
