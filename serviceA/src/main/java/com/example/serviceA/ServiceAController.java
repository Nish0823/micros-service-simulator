package com.example.serviceA;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAController
{
    String TOPIC_NAME = "test";
    String PUBSUB_NAME = "simulatorpubsub";

    //publish a topic in redis pubsub broker
    @GetMapping(path = "/test")
    public String someMethod()
    {
//        String str = "hello";
//        DaprClient client = new DaprClientBuilder().build();
//        client.publishEvent(
//                PUBSUB_NAME,
//                TOPIC_NAME,
//                str).block();

        return "Message Delivered";
    }


}
