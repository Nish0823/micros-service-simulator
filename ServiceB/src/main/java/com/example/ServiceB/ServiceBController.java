package com.example.ServiceB;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController
{

    @GetMapping(path="/hello")
    public String hello()
    {
        String message = "Hello From B";
        return message;

    }
}
