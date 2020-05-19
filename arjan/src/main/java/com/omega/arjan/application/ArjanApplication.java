package com.omega.arjan.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan("com.omega.arjan")
public class ArjanApplication {
  public static void main(String[] args) {
    SpringApplication.run(ArjanApplication.class, args);
  }
}