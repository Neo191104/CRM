package com.hwua;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.hwua.mapper"})
public class SpringbootCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCrmApplication.class, args);
    }

}
