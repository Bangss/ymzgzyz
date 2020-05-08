package com.lingnan.ymzgzyz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ponking
 */
@MapperScan("com.lingnan.ymzgzyz.mapper")
@SpringBootApplication
public class WebApplication {

    public static void main ( String[] args ) {
        SpringApplication.run(WebApplication.class, args);
    }

}
