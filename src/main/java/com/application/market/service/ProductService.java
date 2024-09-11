package com.application.market.service;

import com.application.market.dto.ProductDto;
import com.application.market.entity.Product;
import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    void saveProduct(ProductDto productDto,  MultipartFile imageFile);

    List<Product> getAllProducts();

}
