package com.application.market.service;

import com.application.market.dto.ProductDto;
import com.application.market.entity.Category;
import com.application.market.entity.Product;
import com.application.market.entity.User;
import com.application.market.repository.ProductRepository;
import com.application.market.repository.CategoryRepository;
import com.application.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.coobird.thumbnailator.Thumbnails;
import java.io.IOException;
import java.time.LocalDateTime;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Product> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> getProductsWithFilters(String category, Double minPrice, Double maxPrice, String region, Pageable pageable) {
        return productRepository.findProductsWithFilters(category, minPrice, maxPrice, region, pageable);
    }

    @Override
    public List<Product> getAllProductsSortedByDatePosted() {
        return productRepository.findAllByOrderByDatePostedDesc();
    }

    @Override
    public Page<Product> getProductsByCategory(String categoryName, Pageable pageable) {
        return productRepository.findByCategoryCategoryName(categoryName, pageable);
    }

//    @Override
//    public List<Product> getTop5ProductsByCategory(String categoryName) {
//        Pageable pageable = PageRequest.of(0, 5); // Limit to 5 products
//        return productRepository.findByCategoryCategoryName(categoryName, pageable).getContent();
//    }


    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public long countAllProducts() {
        return productRepository.count();
    }


    public List<Product> getProductsByUser(User user) {
        return productRepository.findByUser(user);
    }

    // Compress image method
    public byte[] compressImageWithThumbnailator(MultipartFile imageFile) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Thumbnails.of(imageFile.getInputStream())
                .size(800, 600)
                .outputFormat("jpg")
                .outputQuality(0.5)
                .toOutputStream(outputStream);

        return outputStream.toByteArray();
    }

    @Override
    public void updateProduct(ProductDto productDto, MultipartFile imageFile) {
        Product product = productRepository.findById(productDto.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setLocation(productDto.getLocation());

        Category category = categoryRepository.findByCategoryName(productDto.getCategory())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);

        try {
            if (!imageFile.isEmpty()) {
                byte[] compressedImage = compressImageWithThumbnailator(imageFile);
                product.setImage(compressedImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload and compress image", e);
        }

        productRepository.save(product);
    }

    public List<Product> getProductsByUserSortedByDate(User user) {
        Sort sortOrder = Sort.by("datePosted").descending();
        return productRepository.findByUser(user, sortOrder);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public void saveProduct(ProductDto productDto, MultipartFile imageFile) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setLocation(productDto.getLocation());
        product.setQuantity(productDto.getQuantity());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        User user = userRepository.findByEmail(currentUsername);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        /*User user = userRepository.findById(1L).orElseThrow(() -> new RuntimeException("User not found"));*/
        product.setUser(user);

        Category category = categoryRepository.findByCategoryName(productDto.getCategory())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);

        try {
            if (!imageFile.isEmpty()) {
                byte[] compressedImage = compressImageWithThumbnailator(imageFile);
                product.setImage(compressedImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload and compress image", e);
        }

        product.setDatePosted(LocalDateTime.now());
        product.setStatus("Available");

        productRepository.save(product);
    }

    @Override
    public Map<String, Long> countProductsPerCategory() {
        Map<String, Long> productCountPerCategory = new HashMap<>();

        productCountPerCategory.put("Metals", productRepository.countProductsByCategory("Metals"));
        productCountPerCategory.put("Battery Recycling", productRepository.countProductsByCategory("Battery Recycling"));
        productCountPerCategory.put("Compost & Food Waste", productRepository.countProductsByCategory("Compost & Food Waste"));
        productCountPerCategory.put("Computer & Electronics", productRepository.countProductsByCategory("Computer & Electronics"));
        productCountPerCategory.put("Glass & Fiberglass", productRepository.countProductsByCategory("Glass & Fiberglass"));
        productCountPerCategory.put("Chemicals", productRepository.countProductsByCategory("Chemicals"));
        productCountPerCategory.put("Paper/Cardboard", productRepository.countProductsByCategory("Paper/Cardboard"));
        productCountPerCategory.put("Plastic", productRepository.countProductsByCategory("Plastic"));
        productCountPerCategory.put("Textiles & Leather", productRepository.countProductsByCategory("Textiles & Leather"));
        productCountPerCategory.put("Tire & Rubber", productRepository.countProductsByCategory("Tire & Rubber"));
        productCountPerCategory.put("Wood", productRepository.countProductsByCategory("Wood"));
        productCountPerCategory.put("Used Commercial Goods", productRepository.countProductsByCategory("Used Commercial Goods"));
        productCountPerCategory.put("Used Clothes", productRepository.countProductsByCategory("Used Clothes"));
        productCountPerCategory.put("Used Equipment", productRepository.countProductsByCategory("Used Equipment"));

        return productCountPerCategory;
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}