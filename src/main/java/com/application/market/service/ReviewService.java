package com.application.market.service;

import com.application.market.entity.Product;
import com.application.market.entity.Review;
import com.application.market.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewService {
    List<Review> getReviewsByProduct(Product product);

    Review saveReview(Review review);

    void addReview(Product product, User user, String comment, int rating);
}
