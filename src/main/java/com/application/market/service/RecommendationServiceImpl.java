package com.application.market.service;

import com.application.market.entity.Category;
import com.application.market.entity.Product;
import com.application.market.entity.User;
import com.application.market.entity.UserActivity;
import com.application.market.repository.ProductRepository;
import com.application.market.repository.UserActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService{

    @Autowired
    private UserActivityRepository userActivityRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getRecommendedProducts(User user) {
        // Step 1: Get user activity (clicked, carted, purchased)
        List<UserActivity> userActivities = userActivityRepository.findByUserOrderByTimestampDesc(user);

        if (userActivities.isEmpty()) {
            // If no activity, return the top recent products as fallback
            return productRepository.findAllByOrderByDatePostedDesc().stream().limit(20).collect(Collectors.toList());
        }

        // Step 2: Count interactions by category
        Map<Category, Long> categoryCountMap = userActivities.stream()
                .collect(Collectors.groupingBy(ua -> ua.getProduct().getCategory(), Collectors.counting()));

        // Sort categories by interaction frequency
        List<Category> topCategories = categoryCountMap.entrySet().stream()
                .sorted(Map.Entry.<Category, Long>comparingByValue().reversed()) // Sort by frequency
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // Step 3: Find products in the top categories
        List<Product> recommendedProducts = productRepository.findByCategoryIn(topCategories);

        // Step 4: Match keywords in the product title or description
        Set<String> keywords = userActivities.stream()
                .flatMap(ua -> Arrays.stream(ua.getProduct().getTitle().split(" "))) // Extract keywords from the product title
                .collect(Collectors.toSet());

        List<Product> finalRecommendedProducts = recommendedProducts.stream()
                .filter(product -> keywords.stream().anyMatch(keyword ->
                        product.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                                product.getDescription().toLowerCase().contains(keyword.toLowerCase())))
                .distinct()
                .limit(20)
                .collect(Collectors.toList());

        return finalRecommendedProducts;
    }
}
