package com.example.serviceA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/helloworld/serviceA")
public class ServiceAController
{
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String hello()
    {
        String url = "http://producer:8080/hello-from/server";
        return restTemplate.getForObject(url, String.class);
    }

}
