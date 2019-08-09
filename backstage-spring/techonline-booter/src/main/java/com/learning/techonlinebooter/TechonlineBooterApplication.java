package com.learning.techonlinebooter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.learning")
public class TechonlineBooterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechonlineBooterApplication.class, args);
    }

}
