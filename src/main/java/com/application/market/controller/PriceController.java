package com.application.market.controller;

import com.application.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PriceController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAveragePrice")
    public ResponseEntity<Map<String, Object>> getAveragePrice(@RequestParam String category) {
        Double averagePrice = productService.getAveragePriceForCategory(category);

        if (averagePrice != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("averagePrice", averagePrice);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
