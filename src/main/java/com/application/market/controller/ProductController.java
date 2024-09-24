package com.application.market.controller;

import com.application.market.dto.ProductDto;
import com.application.market.entity.Product;
import com.application.market.entity.User;
import com.application.market.entity.UserActivity;
import com.application.market.repository.CategoryRepository;
import com.application.market.repository.ProductRepository;
import com.application.market.repository.UserActivityRepository;
import com.application.market.repository.UserRepository;
import com.application.market.service.ProductService;
import com.application.market.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserActivityRepository userActivityRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecommendationService recommendationService;



    @GetMapping("/addproduct")
    public String showProductForm(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "addprod";
    }

    @GetMapping("/shopDetail-{id}")
    public String getProductDetails(@PathVariable("id") Long id, Model model) {
        Product product = productService.findProductById(id);

        if (product == null) {
            model.addAttribute("errorMessage", "Product not found");
            return "404";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String currentUsername = authentication.getName();
            User user = userRepository.findByEmail(currentUsername);

            if (user != null) {
                // Log the user's activity
                UserActivity activity = new UserActivity();
                activity.setUser(user);
                activity.setProduct(product);
                activity.setActivityType(UserActivity.ActivityType.CLICK);
                activity.setTimestamp(LocalDateTime.now());

                userActivityRepository.save(activity); // Save the activity
            }
        }

        // Add product to the model
        model.addAttribute("page", "shopDetail");
        model.addAttribute("product", product);

        return "shopDetail";
    }


    @PostMapping("/submit-product")
    public String submitProduct(@ModelAttribute ProductDto productDto,
                                @RequestParam("imageFile") MultipartFile imageFile,
                                RedirectAttributes redirectAttributes) {
        try {
            if (imageFile.getSize() > 10485760) { // 10 MB size limit
                throw new IllegalStateException("File size too large");
            }
            productService.saveProduct(productDto, imageFile);
            redirectAttributes.addFlashAttribute("productAdded", true);
            return "redirect:/shop?productAdded=true";
        } catch (IllegalStateException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "File size exceeds the 10MB limit.");
            return "redirect:/addproduct?error=fileTooLarge";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error uploading product.");
            return "redirect:/addproduct?error=true";
        }
    }

    @GetMapping("/editProduct-{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.findProductById(id);

        if (product != null) {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setTitle(product.getTitle());
            productDto.setDescription(product.getDescription());
            productDto.setPrice(product.getPrice());
            productDto.setQuantity(product.getQuantity());
            productDto.setLocation(product.getLocation());
            productDto.setCategory(product.getCategory().getCategoryName());

            model.addAttribute("productDto", productDto);
            return "editProductForm";
        } else {
            model.addAttribute("errorMessage", "Product not found");
            return "404";
        }
    }

    @PostMapping("/update-product")
    public String updateProduct(@ModelAttribute ProductDto productDto,
                                @RequestParam("imageFile") MultipartFile imageFile,
                                RedirectAttributes redirectAttributes) {
        try {
            productService.updateProduct(productDto, imageFile);
            redirectAttributes.addFlashAttribute("productUpdated", true);
            return "redirect:/shopDetail-" + productDto.getId();
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error updating product.");
            return "redirect:/editproduct-" + productDto.getId() + "?error=true";
        }
    }

    @PostMapping("/productStatus-{id}")
    public String productStatus(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product with id " + id + " not found"));
        if ("Available".equals(product.getStatus())) {
            product.setStatus("Unavailable");
        } else {
            product.setStatus("Available");
        }
        productRepository.save(product);
        return "redirect:/profile-articles";
    }

    @GetMapping("/deleteProduct-{id}")
    public String deleteProduct(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productService.deleteProductById(id); // apel către serviciu pentru a șterge produsul
            redirectAttributes.addFlashAttribute("productDeleted", true);
            return "redirect:/profile-articles"; // Redirecționezi la pagina unde sunt afișate produsele
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Product not found");
            return "redirect:/profile-articles"; // Redirecționezi la pagina de produse
        }
    }

    @GetMapping("/recommended")
    public String getRecommendedProducts(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        User user = userRepository.findByEmail(currentUsername);

        if (user != null) {
            List<Product> recommendedProducts = recommendationService.getRecommendedProducts(user);
            model.addAttribute("recommendedProducts", recommendedProducts);
            return "recommended"; // Points to Thymeleaf template 'recommended.html'
        } else {
            model.addAttribute("errorMessage", "User not found");
            return "404";
        }
    }

}