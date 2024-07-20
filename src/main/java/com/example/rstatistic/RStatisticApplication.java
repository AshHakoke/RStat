package com.example.rstatistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class RStatisticApplication {
    public static void main(String[] args) {
        SpringApplication.run(RStatisticApplication.class, args);
    }

}