package com.application.market.repository;

import com.application.market.entity.Review;
import com.application.market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProduct(Product product);
    void deleteByProductId(Long productId);

    List<Review> findByProductId(Long productId);
}