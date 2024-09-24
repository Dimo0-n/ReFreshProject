package com.application.market.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Service
public class OllamaTestService {

    private final String ollamaApiUrl = "http://localhost:11434/api/chat"; // Change this if needed

    public String sendDummyRequest() {
        RestTemplate restTemplate = new RestTemplate();
        String jsonRequest = "{ \"model\": \"llama3.1:8b\", \"messages\": [ {\"role\": \"user\", \"content\": \"Hello, this is a test.\" } ], \"stream\": false }";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(jsonRequest, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(ollamaApiUrl, request, String.class);
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return "Error: " + e.getMessage();
        }
    }

}
