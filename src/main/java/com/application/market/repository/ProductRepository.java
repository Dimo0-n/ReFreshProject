package com.application.market.repository;

import com.application.market.entity.Category;
import com.application.market.entity.Product;
import com.application.market.entity.User;
import com.application.market.entity.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByTitleAndCategoryId(String title, Long categoryId);

    List<Product> findAllByOrderByDatePostedDesc();

    Page<Product> findAll(Pageable pageable);

    List<Product> findByUser(User user);

    @Query("SELECT COUNT(p) FROM Product p WHERE p.category.categoryName = :categoryName")
    long countProductsByCategory(String categoryName);

    Page<Product> findByCategoryCategoryName(String categoryName, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.location LIKE CONCAT(:region, '%')")
    Page<Product> findByRegion(@Param("region") String region, Pageable pageable);

    List<Product> findByUser(User user, Sort sort);
    @Query("SELECT p FROM Product p WHERE " +
            "p.status = 'Available' AND " +
            "(:category IS NULL OR :category = '' OR p.category.categoryName = :category) " +
            "AND (:minPrice IS NULL OR p.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.price <= :maxPrice) " +
            "AND (:region IS NULL OR :region = '' OR p.location LIKE CONCAT(:region, '%'))")
    Page<Product> findProductsWithFilters(
            @Param("category") String category,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("region") String region,
            Pageable pageable);

    List<Product> findByStatus(String status);

    @Query("SELECT AVG(p.price) FROM Product p WHERE p.category.categoryName = :categoryName")
    Double findAveragePriceByCategory(@Param("categoryName") String categoryName);

    List<Product> findByCategoryIn(List<Category> categories);

    @Query("SELECT p FROM Product p WHERE p.title LIKE CONCAT('%', :keyword, '%') OR p.description LIKE CONCAT('%', :keyword, '%')")
    Page<Product> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);


}