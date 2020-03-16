package com.example.streams.kafkastreamer;

import com.example.streams.kafkastreamer.controller.DummyController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.MessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.Supplier;

@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMessageVerifier
public abstract class KafkaStreamerApplicationTests {


  @Autowired
  private DummyController dummyController;

  public void supply() {

    dummyController.handlePost();
  }
}
