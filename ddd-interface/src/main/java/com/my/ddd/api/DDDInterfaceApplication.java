package com.my.ddd.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching
@SpringBootApplication
@ComponentScan(basePackages = {"com.my.ddd"})
public class DDDInterfaceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DDDInterfaceApplication.class, args);
    }
}