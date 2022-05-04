package com.example.serviceA;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAController
{
    String TOPIC_NAME = "test";
    String PUBSUB_NAME = "simulatorpubsub";

    //publish a topic in redis pubsub broker
    @RequestMapping(path = "/hello")
    public String someMethod()
    {
        String str = "hello";
        DaprClient client = new DaprClientBuilder().build();
        client.publishEvent(
                PUBSUB_NAME,
                TOPIC_NAME,
                str).block();

        return "Message Delivered";
    }
}
