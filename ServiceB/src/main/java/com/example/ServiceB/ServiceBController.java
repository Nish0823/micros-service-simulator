package com.example.ServiceB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
/*
    @Topic(name = "test", pubsubName = "simulatorpubsub")
    @PostMapping(path = "/test")
    public ResponseEntity<String> getCheckout(@RequestBody(required = false)  CloudEvent<String> cloudEvent) throws IOException, InterruptedException {
        logger.info("Received :"  + cloudEvent.getData());
        //callServiceC();
        System.out.println("Service B has been triggered.");
        return ResponseEntity.ok("SUCCESS");

    }*/
/*
    @Topic(name = "dependent_topic", pubsubName = "b_calls_c")
    @PostMapping(path="/dependent_test")
    public ResponseEntity<String> invokeServiceC(@RequestBody(required = false)  CloudEvent<String> cloudEvent) throws IOException, InterruptedException
    {
        logger.info("Received :"+cloudEvent.getData());
        System.out.println("Going to invoke service C");
        String url= "http://localhost:3502/v1.0/invoke/service-c/method/test";
        RestTemplate temp = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        return ResponseEntity.ok("SUCCESS");
    }*/

    @RequestMapping(path = "/test")
    public String someMethod()
    {
        System.out.println("B has been invoked.");
        return "Service B has been invoked.";
    }

    @RequestMapping(path = "/dependent_topic")
    public String someMethodFromB()
    {
        System.out.println("Going to invoke service C");
        String url= "http://localhost:3502/v1.0/invoke/service-c/method/test";
        RestTemplate temp = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        return result;
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
