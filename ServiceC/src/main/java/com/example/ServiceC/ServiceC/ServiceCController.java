package com.example.ServiceC.ServiceC;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceCController
{

    @GetMapping(path = "/hello-there")
    public String callFromB()
    {
        return "hello there";
    }
}
