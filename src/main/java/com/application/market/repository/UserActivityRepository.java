package com.application.market.repository;

import com.application.market.entity.Product;
import com.application.market.entity.User;
import com.application.market.entity.UserActivity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {
    List<UserActivity> findByUserOrderByTimestampDesc(User user);
    @Modifying
    @Transactional
    @Query("DELETE FROM UserActivity ua WHERE ua.product.id = :productId")
    void deleteByProductId(@Param("productId") Long productId);
}
