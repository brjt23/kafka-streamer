package com.example.streams.kafkastreamer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.streams.kafkastreamer.service.ProductionService;

@RestController
public class GenerateNameController {
	@Autowired
	ProductionService productionService;
	
	@PostMapping(value="/")
	public void generateName() {
		productionService.generate();
	}
}
