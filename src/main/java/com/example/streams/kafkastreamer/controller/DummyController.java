package com.example.streams.kafkastreamer.controller;

import com.example.streams.kafkastreamer.config.EventSupplier;
import com.github.javafaker.Faker;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {
  @PostMapping(value = "/")
  public void handlePost() {

    Faker faker = new Faker();
    Message<String> message = MessageBuilder.withPayload(faker.chuckNorris().fact()).build();
    EventSupplier.processor.onNext(message);
  }
}
