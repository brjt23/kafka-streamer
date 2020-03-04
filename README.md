# Kafka streamer
This is a simple sample to learn how to work with [spring cloud stream](https://cloud.spring.io/spring-cloud-static/spring-cloud-stream/3.0.1.RELEASE/reference/html/spring-cloud-stream.html#spring-cloud-stream-reference). This sample has been created based on the official 
documentation and official [spring-cloud-stream-samples](https://github.com/spring-cloud/spring-cloud-stream-samples). To run this project just build it with mvn clean package and run 
the generated jar under the /target directory. 

## Running kafka
This project contains a docker compose that runs Zookiper and Kafka. Start it running. 

- docker-compose up -d

## Sending messages to kafka
You can send messages to kafka topics running kafka [commands](https://kafka.apache.org/quickstart) in the docker instance you launched with the docker-compose. 
So to send a message into a topic called 'test' you can run 

-  docker exec -it kafka-dynamic-source /opt/kafka/bin/kafka-console-producer.sh --broker-list 127.0.0.1:9092 --topic test

This will open the que and any string you write in the console will be sent into the topic. 

## Subscribing to groups
To handle scalability we can take profit from [groups](https://cloud.spring.io/spring-cloud-static/spring-cloud-stream/3.0.1.RELEASE/reference/html/spring-cloud-stream.html#consumer-groups)
by adding the property spring.cloud.stream.bindings.uppercase-in-0.group=testGroup. To test it, you can launch more than 
once the application and check that only one application will get the message from the test topic.

## Tags
To reuse code but keep different implementation of the binders I'm using git tags.
 - Tag 1.0: Tag 1.0 contains a simple implementation using functions that receive String messages. There are simple 
 bindings and a group binding.