package com.example.streams.kafkastreamer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

@Service
@EnableBinding(Source.class)
public class ProductionService {
	
	private MessageChannel output;
	
	@Autowired
	public ProductionService(MessageChannel output) {
		this.output = output;
	}
	
	public void generate() {
		Faker faker = new Faker();
		output.send(MessageBuilder.withPayload(faker.name().fullName()).build());
	}
	
}
