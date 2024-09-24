package com.application.market.controller;

import com.application.market.service.ChatAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/chat")
public class ChatAiController {

    @Autowired
    private ChatAiService chatAiService;

    @PostMapping
    public ResponseEntity<Map<String, String>> handleUserMessage(@RequestBody Map<String, String> payload) {
        String userMessage = payload.get("message");
        String botReply = chatAiService.getBotReply(userMessage);

        Map<String, String> response = new HashMap<>();
        response.put("reply", botReply);
        return ResponseEntity.ok(response);
    }
}

