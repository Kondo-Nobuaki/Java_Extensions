package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example", "com.config"})
public class MyTomcatServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyTomcatServerApplication.class, args);
    }
}