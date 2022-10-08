package com.example.demoproweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.**"})
public class DemoProWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProWebApplication.class, args);
    }

}
