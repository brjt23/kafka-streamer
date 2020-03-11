package com.example.streams.kafkastreamer;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.streams.kafkastreamer.vo.ValueVO;
import com.github.javafaker.Faker;

import io.cloudevents.v1.CloudEventBuilder;
import io.cloudevents.v1.CloudEventImpl;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

@SpringBootApplication
@RestController
public class KafkaStreamerApplication {

  private final EmitterProcessor<Message<String>> processor = EmitterProcessor.create();
	
  public static void main(String[] args) {

    SpringApplication.run(KafkaStreamerApplication.class, args);
  }
  
  @PostMapping(value="/")
  public void handlePost() {
	  Faker faker = new Faker();
	  Message<String> message = MessageBuilder.withPayload(faker.chuckNorris().fact()).build();
	  processor.onNext(message);
  }

  @Bean
  public Supplier<Flux<Message<String>>> supplier() {
	  return () -> processor;
  }
  
  @Bean
  public Function<String, CloudEventImpl<ValueVO>> uppercase() {

    return value -> {
      System.out.println("Received: " + value);
      String id = UUID.randomUUID().toString();
      CloudEventBuilder<ValueVO> cloudEventBuilder = CloudEventBuilder.builder();
      try {
        URI source = new URI("file:///com/example/streams/kafkastreamer");

        String type = "My.test.event.type";
        cloudEventBuilder.withId(id).withSource(source).withType(type).withDataContentType("application/json")
            .withData(new ValueVO().setValue(value.toUpperCase()));
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }
      return cloudEventBuilder.build();
    };
  }
}
