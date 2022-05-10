package com.example.ServiceC.ServiceC;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class ServiceCController
{
    private static final Logger logger = LoggerFactory.getLogger(ServiceCController.class);
/*
    @Topic(name = "test", pubsubName = "simulatorpubsub")
    @PostMapping(path = "/test")
    public ResponseEntity<String> getCheckout(@RequestBody(required = false)  CloudEvent<String> cloudEvent) throws IOException, InterruptedException {
        logger.info("Received :"  + cloudEvent.getData());
        System.out.println("Service C has been triggered.");
        return ResponseEntity.ok("SUCCESS");

    } */

    @GetMapping(path = "/hello-there")
    public String callFromB()
    {
        return "hello there";
    }

    @RequestMapping(path = "/test")
    public String someMethod()
    {
        System.out.println("C has been invoked");
        return "Service C has been invoked.";
    }
}
