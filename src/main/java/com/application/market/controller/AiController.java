package com.application.market.controller;
import com.application.market.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AiController {

    @Autowired
    private AiService aiService;

    @PostMapping("/generate-description")
    public ResponseEntity<Map<String, String>> generateDescription(@RequestBody Map<String, String> request) {
        String title = request.get("title");
        String description = request.get("description");

        String generatedDescription = aiService.callAiModel(title, description);

        Map<String, String> response = new HashMap<>();
        response.put("generatedDescription", generatedDescription);

        return ResponseEntity.ok(response);
    }
}

