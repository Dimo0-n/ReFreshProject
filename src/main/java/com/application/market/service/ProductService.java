package com.application.market.service;

import com.application.market.dto.ProductDto;
import com.application.market.entity.Product;
import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ProductService {

    void saveProduct(ProductDto productDto, MultipartFile imageFile);

    List<Product> getAllProducts();

    List<Product> getAllProductsSortedByDatePosted();

    Page<Product> getProducts(Pageable pageable);

    Map<String, Long> countProductsPerCategory();

    Page<Product> getProductsByCategory(String categoryName, Pageable pageable);

    long countAllProducts();

    Page<Product> getProductsWithFilters(String category, Double minPrice, Double maxPrice, String region, Pageable pageable);
}