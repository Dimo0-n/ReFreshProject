package com.application.market.service;

import com.application.market.entity.Product;
import com.application.market.entity.Review;
import com.application.market.entity.User;
import com.application.market.entity.UserActivity;
import com.application.market.repository.ReviewRepository;
import com.application.market.repository.UserActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserActivityRepository userActivityRepository;

    public List<Review> getReviewsByProduct(Product product) {
        return reviewRepository.findByProduct(product);
    }

    public void addReview(Product product, User user, String comment, int rating) {
        Review review = new Review();
        review.setProduct(product);
        review.setUser(user);
        review.setComment(comment);
        review.setRating(rating);
        review.setDatePosted(LocalDateTime.now());
        reviewRepository.save(review);
    }

    public Review saveReview(Review review) {
        review.setDatePosted(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
    }

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public void deleteByProductId(Long productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);
        reviews.forEach(reviewRepository::delete); // Deletes reviews
    }
}
