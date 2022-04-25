package com.example.serviceA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@RestController
public class ServiceAController
{
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private static final String DAPR_HTTP_PORT = System.getenv().getOrDefault("DAPR_HTTP_PORT", "3501");

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/hello")
    public String hello() throws IOException, InterruptedException {
        String dapr_url = "http://localhost:"+DAPR_HTTP_PORT+"/hello";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(dapr_url))
                .header("dapr-app-id", "serviceb")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return restTemplate.getForObject(response.toString(),String.class);
    }

}
