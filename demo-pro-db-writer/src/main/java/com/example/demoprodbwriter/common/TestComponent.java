package com.example.demoprodbwriter.common;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestComponent {
    public String testComponent() {
        log.info("In TestComponent!");
        return "In TestComponent!";
    }
}
