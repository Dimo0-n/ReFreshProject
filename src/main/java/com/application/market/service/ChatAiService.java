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
public class ChatAiService {

    private final String ollamaApiUrl = "http://localhost:11434/api/chat";

    public String getBotReply(String userMessage) {
        // Răspunsuri predefinite pentru diferite mesaje
        switch (userMessage.toLowerCase()) {
            case "what is the platform?":
                return "The platform allows users to buy and sell recyclable products.";
            case "what products can i sell?":
                return "You can sell recyclable items such as plastic, paper, metal, and electronics.";
            case "where? why?":
                return "The platform is available for users globally to promote environmental sustainability.";
            default:
                // În cazurile neacoperite, apelăm modelul AI
                return getAiGeneratedResponse(userMessage);
        }
    }

    // Metodă care apelează AI-ul folosind metoda callAiModel
    private String getAiGeneratedResponse(String userMessage) {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonRequest = String.format(
                "{ \"model\": \"llama3.1:8b\", \"messages\": [ {\"role\": \"user\", \"content\"" +
                        ": \"Generate an answer that is only for this question: '%s'. " +
                        "Make all the answers related to the theme of eco and recycling." +
                        "If the user deviates from the topic of eco, recycling, RETURN IT to the topic. Stay within the 25 word limit\" } ], \"stream\": false }",
                userMessage
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
