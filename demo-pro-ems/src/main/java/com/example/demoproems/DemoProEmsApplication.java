package com.example.demoproems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoProEmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProEmsApplication.class, args);
    }

}
