package com.application.market.service;

import com.application.market.dto.ProductDto;
import com.application.market.entity.Category;
import com.application.market.entity.Product;
import com.application.market.entity.User;
import com.application.market.repository.ProductRepository;
import com.application.market.repository.CategoryRepository;
import com.application.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Compress image method
    public byte[] compressImageWithThumbnailator(MultipartFile imageFile) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Thumbnails.of(imageFile.getInputStream())
                .size(800, 600) // Resize to a fixed size; adjust as needed
                .outputFormat("jpg")
                .outputQuality(0.5) // Compression quality (0.0 to 1.0)
                .toOutputStream(outputStream);

        return outputStream.toByteArray();
    }

    @Override
    public void saveProduct(ProductDto productDto, MultipartFile imageFile) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setLocation(productDto.getLocation());
        product.setQuantity(productDto.getQuantity());

        User user = userRepository.findById(1L).orElseThrow(() -> new RuntimeException("User not found"));
        product.setUser(user);

        Category category = categoryRepository.findByCategoryName(productDto.getCategory())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);

        try {
            if (!imageFile.isEmpty()) {
                byte[] compressedImage = compressImageWithThumbnailator(imageFile); // Compress the image here
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
}
