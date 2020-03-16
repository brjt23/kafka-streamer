package com.example.streams.kafkastreamer.config;

import org.springframework.cloud.function.context.PollableBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Configuration
public class EventSupplier {
  public static final EmitterProcessor<Message<String>> processor = EmitterProcessor.create();

  @PollableBean
  public Supplier<Flux<Message<String>>> supplier() {

    return () -> processor;
  }
}
