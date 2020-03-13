def contractDsl = org.springframework.cloud.contract.spec.Contract.make {
    label 'some_label'
    input {
       triggeredBy("supply()")
    }
    outputMessage {
        sentTo('supplier-out-0')
        body(
                anyNonBlankString()
                )
        headers {
            messagingContentType(applicationJson())
        }
    }
}