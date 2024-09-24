package com.application.market.service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AiServiceImpl implements AiService{

    private final String ollamaApiUrl = "http://localhost:11434/api/chat";

    public String callAiModel(String title, String description) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonRequest = String.format(
                "{ \"model\": \"llama3.1:8b\", \"messages\": [ {\"role\": \"user\", \"content\": \"Generate a concise product description based on the title: '%s' and keywords: '%s'.\" } ], \"stream\": false }",
                title, description
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequest, headers);

        ResponseEntity<String> responseEntity;
        try {
            responseEntity = restTemplate.postForEntity(ollamaApiUrl, requestEntity, String.class);
        } catch (Exception e) {
            return "Error calling AI model: " + e.getMessage();
        }

        // Extract the response body
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            try {
                JsonNode jsonResponse = objectMapper.readTree(responseEntity.getBody());
                return jsonResponse.path("message").path("content").asText().trim();
            } catch (Exception e) {
                return "Error parsing AI model response: " + e.getMessage();
            }
        } else {
            return "Error from AI model: " + responseEntity.getStatusCode();
        }
    }
}
