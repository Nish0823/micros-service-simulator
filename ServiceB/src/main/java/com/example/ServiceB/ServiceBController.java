package com.example.ServiceB;

import io.dapr.Topic;
import io.dapr.client.domain.CloudEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@RequestMapping
public class ServiceBController
{

    private static final Logger logger = LoggerFactory.getLogger(ServiceBController.class);

    RestTemplate restTemplate = new RestTemplate();

/*
    subscription model created programmatically,
    subscribes to a topic which is published by service A
    and calls method callServiceC() after the message from service A is received
    Topic name = test
    pubsubname = simulatorpubsub
    route = /test
*/

    @Topic(name = "test", pubsubName = "simulatorpubsub")
    @PostMapping(path = "/test")
    public ResponseEntity<String> getCheckout(@RequestBody(required = false)  CloudEvent<String> cloudEvent) throws IOException, InterruptedException {
        logger.info("Received :"  + cloudEvent.getData());
        callServiceC();
        return ResponseEntity.ok("SUCCESS");

    }

    /*

    method to simulate an api call to service C
    the string uri can be changed accordignly,
    currently it is calling service - C "/hello-there" api from port 3501 , which is service A's port

     */
    public void callServiceC() throws InterruptedException {
        final String uri = "http://localhost:3501/v1.0/invoke/service-c/method/hello-there";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
    }



}
