package com.example.streams.kafkastreamer.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ValueVO {
  String value;
}
