package com.example.polaris;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(
        scanBasePackages = {"com.polaris"},
        exclude = {MultipartAutoConfiguration.class}
)
@EnableTransactionManagement
@MapperScan("com.polaris.common.mapper")
public class PolarisApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolarisApplication.class, args);
    }

}
