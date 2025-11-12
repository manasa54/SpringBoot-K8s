package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    @GetMapping("/hello")
    public String hello() {
        return "Hello !! Manasa Kunchala... Welcome to Spring Boot Application";
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}