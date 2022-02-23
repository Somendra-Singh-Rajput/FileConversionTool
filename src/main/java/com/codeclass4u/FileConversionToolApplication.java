package com.codeclass4u;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.SpringVersion;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class FileConversionToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileConversionToolApplication.class, args);
        System.out.println("Springboot Version : "+SpringVersion.getVersion());
    }

}
