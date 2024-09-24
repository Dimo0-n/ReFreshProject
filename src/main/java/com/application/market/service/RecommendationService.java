package com.application.market.service;

import com.application.market.entity.Product;
import com.application.market.entity.User;

import java.util.List;

public interface RecommendationService {
    List<Product> getRecommendedProducts(User user);
}
