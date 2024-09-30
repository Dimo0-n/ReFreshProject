package com.application.market.repository;

import com.application.market.entity.Checkout;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Checkout c WHERE c.product.id = :productId")
    void deleteByProductId(@Param("productId") Long productId);

}
