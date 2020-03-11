def contractDsl = org.springframework.cloud.contract.spec.Contract.make {
    label 'some_label'
    input {
        messageFrom('uppercase-in-0')
        messageBody('MIAU')
        messageHeaders {
            header('sample', 'header')
        }
    }
    outputMessage {
        sentTo('uppercase-out-0')
        body(
                id: anyUuid(),
                source: "file:///com/example/streams/kafkastreamer",
                specversion: "1.0",
                type: "My.test.event.type",
                datacontenttype: "application/json",
                data: value(value: "MIAU"),
                )
        headers {
            messagingContentType(applicationJson())
        }
    }
}