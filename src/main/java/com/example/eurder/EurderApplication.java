package com.example.eurder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class EurderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurderApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/*")) //restriction based on url
                .apis(RequestHandlerSelectors.basePackage("com.example.eurder")) //restriction based on package name
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Örder API",
                "Sample API for Örder",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Sven Verboven",
                        "http://localhost8080",
                        "sven_verboven@hotmail.com"),
                "API License",
                "http://localhost8080",
                Collections.emptyList());
    }
}

