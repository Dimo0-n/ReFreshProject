package com.application.market.repository;

import com.application.market.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUserId(Long userId);

    @Query("SELECT SUM(c.price) FROM Cart c")
    Double getTotalPrice();

    Cart findByUserIdAndProductId(Long userId, Long productId);
}

