package com.application.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrivacyPolicyController {

    @GetMapping("/privacy-policy")
    public String showPrivacyPolicy() {
        return "privacy-policy"; //
    }
}
