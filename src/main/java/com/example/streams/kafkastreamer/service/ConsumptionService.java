package com.example.streams.kafkastreamer.service;

import org.springframework.stereotype.Service;

@Service
public class ConsumptionService {

  /**
   * Process a consumption
   * @param msg
   * @return
   */
  public String process(String msg) {
    return msg.toUpperCase();
  }
}
