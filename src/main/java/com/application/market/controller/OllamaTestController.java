package com.application.market.controller;
import com.application.market.service.OllamaTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaTestController {

    @Autowired
    private OllamaTestService ollamaTestService;

    @GetMapping("/test-ollama") // Make sure this matches your request
    public String testOllama() {
        return ollamaTestService.sendDummyRequest();
    }
}

