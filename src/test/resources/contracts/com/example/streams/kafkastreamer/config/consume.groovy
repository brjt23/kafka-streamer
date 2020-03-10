def contractDsl = org.springframework.cloud.contract.spec.Contract.make {
    label 'some_label'
    input {
        messageFrom('uppercase-in-0')
        messageBody(['MIAU'])
        messageHeaders {
            header('sample', 'header')
        }
    }
    outputMessage {
        sentTo('uppercase-out-0')
        body('''{ 
                "attributes" : {
                    "id": "com.example.streams.kafkastreamer.KafkaStreamerApplication$$EnhancerBySpringCGLIB$$cf6cc14c2020-03-05T12:07:05.366",
                    "source": "file:///com/example/streams/kafkastreamer",
                    "specversion": "1.0",
                    "type": "My.test.event.type",
                    "datacontenttype": "application/json",
                    "dataschema": null,
                    "subject": null,
                    "time": null
                    },
                "data": {"value": "MIAU"},
                "dataBase64": null,
                "extensions": {"specversion": "1.0"},
                "extensionsFormats": [] 
                }''')
        headers {
            messagingContentType(applicationJson())
        }
    }
}