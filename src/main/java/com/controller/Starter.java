package com.controller;

import com.init.ApiConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@Import(ApiConfiguration.class)
public class Starter {

    public static void main(final String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}
