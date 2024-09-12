package com.application.market.repository;

import com.application.market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByTitleAndCategoryId(String title, Long categoryId);

    List<Product> findAllByOrderByDatePostedDesc();

    Page<Product> findAll(Pageable pageable);

}