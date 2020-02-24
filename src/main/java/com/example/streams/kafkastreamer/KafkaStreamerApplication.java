package com.example.streams.kafkastreamer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.function.Function;

@SpringBootApplication
public class KafkaStreamerApplication {

  public static void main(String[] args) {

    SpringApplication.run(KafkaStreamerApplication.class, args);
  }

  @Bean
  public Function<String, String> uppercase() {
    return value -> {
      System.out.println("Received: " + value);
      return value.toUpperCase();
    };
  }}
