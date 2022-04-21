package com.example.serviceA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ServiceAApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(ServiceAApplication.class, args);
	}


}

@Configuration
class Config
{
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
}
