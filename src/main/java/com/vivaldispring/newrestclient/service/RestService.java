package com.vivaldispring.newrestclient.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service
public class RestService {



    public void setRestClient(){

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate =
                restTemplateBuilder
                        .setConnectTimeout(Duration.ofSeconds(5))
                        .setReadTimeout(Duration.ofSeconds(6))
                        .build();

        RestClient restClient = RestClient.create(restTemplate);

        ResponseEntity<String> result = restClient
                .get()
                .uri("http://localhost:6969/wait/5")
                .retrieve()
                .toEntity(String.class);

        System.out.println("Response status: " + result.getStatusCode());
        System.out.println("Response headers: " + result.getHeaders());
        System.out.println("Contents: " + result.getBody());

    }

    public void setRestTemplate(){

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

        RestTemplate restTemplate =
                restTemplateBuilder
                        .setConnectTimeout(Duration.ofSeconds(5))
                        .setReadTimeout(Duration.ofSeconds(6))
                        .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> entity = new HttpEntity<Object>(headers);

        ResponseEntity<String> response = null;
        try {

            response = restTemplate.
                    exchange("http://localhost:6969/wait/5", HttpMethod.GET, entity, String.class);

            System.out.println(response.getBody());

        } catch (Exception e) {
            System.out.println("http://localhost:6969/wait/5".concat(" error message: ").concat(e.getMessage()));
        }


    }



}
