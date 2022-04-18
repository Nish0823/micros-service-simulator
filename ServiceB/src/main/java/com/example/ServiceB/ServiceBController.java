package com.example.ServiceB;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hello-from/server")
public class ServiceBController
{



    @GetMapping
    public String hello()
    {
        return "Hello from Serivce B ";
    }
}
