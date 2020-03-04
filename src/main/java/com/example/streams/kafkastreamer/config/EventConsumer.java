package com.example.streams.kafkastreamer.config;

import com.example.streams.kafkastreamer.service.ConsumptionService;
import com.example.streams.kafkastreamer.vo.ValueVO;
import io.cloudevents.v1.CloudEventImpl;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
  public Function<CloudEventImpl<ValueVO>, String> consume() {

    return value -> {
      // By default jackson uses link list object to serialize non identified objects as link lists, so we need to map
      // the link list into ValueVO otherwise the application will crash. I've included ModelMapper cause is the most
      // quick since requires no set up.
      ValueVO valueVO = new ModelMapper().map(value.getData().get(), ValueVO.class);
      log.info("Consuming " + valueVO.getValue());
      return consumptionService.process(valueVO.getValue());
    };
  }
}
