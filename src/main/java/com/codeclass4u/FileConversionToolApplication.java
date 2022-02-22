package com.codeclass4u;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class FileConversionToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileConversionToolApplication.class, args);
    }
}
