package com.example.streams.kafkastreamer;

import com.example.streams.kafkastreamer.vo.ValueVO;
import io.cloudevents.v1.CloudEventBuilder;
import io.cloudevents.v1.CloudEventImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import java.util.function.Function;

@SpringBootApplication
public class KafkaStreamerApplication {

  public static void main(String[] args) {

    SpringApplication.run(KafkaStreamerApplication.class, args);
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
