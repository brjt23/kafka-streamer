package com.example.streams.kafkastreamer.config;

import com.example.streams.kafkastreamer.service.ConsumptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@Slf4j
public class EventConsumer {

  @Autowired
  private ConsumptionService consumptionService;

  @Bean
  public Function<String, String> consume() {

    return value -> {
      log.info("Consuming " + value);
      return consumptionService.process(value);
    };
  }
}
