package com.omega.habbit.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan("com.omega.habbit")
public class HabbitApplication {
  public static void main(String[] args) {
    SpringApplication.run(HabbitApplication.class, args);
  }
}