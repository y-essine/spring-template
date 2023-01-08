package com.example.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Exam {

    public static void main(String[] args) {
        SpringApplication.run(Exam.class, args);
    }

}
