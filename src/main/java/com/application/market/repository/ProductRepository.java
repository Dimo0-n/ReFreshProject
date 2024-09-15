package com.application.market.repository;

import com.application.market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByTitleAndCategoryId(String title, Long categoryId);

    List<Product> findAllByOrderByDatePostedDesc();

    Page<Product> findAll(Pageable pageable);

    @Query("SELECT COUNT(p) FROM Product p WHERE p.category.categoryName = :categoryName")
    long countProductsByCategory(String categoryName);

    Page<Product> findByCategoryCategoryName(String categoryName, Pageable pageable);

    Page<Product> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);
    Page<Product> findByPriceGreaterThanEqual(Double minPrice, Pageable pageable);


}