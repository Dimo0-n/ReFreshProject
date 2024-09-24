package com.application.market.controller;

import com.application.market.entity.Product;
import com.application.market.entity.User;
import com.application.market.entity.UserActivity;
import com.application.market.repository.ProductRepository;
import com.application.market.repository.UserRepository;
import com.application.market.service.ProductService;
import com.application.market.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
public class ShopController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("categories")
    public List<String> getCategories() {
        return List.of(
                "Metals", "Battery Recycling", "Compost & Food Waste", "Computer & Electronics",
                "Glass & Fiberglass", "Chemicals", "Paper/Cardboard", "Plastic",
                "Textiles & Leather", "Tire & Rubber", "Wood",
                "Used Commercial Goods", "Used Clothes", "Used Equipment"
        );
    }

    @GetMapping("/shop")
    public String shop(@RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "category", defaultValue = "") String category,
                       @RequestParam(value = "minPrice", required = false) Double minPrice,
                       @RequestParam(value = "maxPrice", required = false) Double maxPrice,
                       @RequestParam(value = "sort", required = false) String sort,
                       @RequestParam(value = "region", required = false) String region,
                       Model model) {

        if (minPrice == null) minPrice = 0.0;
        if (maxPrice == null) maxPrice = Double.MAX_VALUE;

        Sort sortOrder = Sort.by("datePosted").descending();

        if (sort != null && !sort.isEmpty()) {
            switch (sort) {
                case "priceAsc":
                    sortOrder = Sort.by("price").ascending();
                    break;
                case "priceDesc":
                    sortOrder = Sort.by("price").descending();
                    break;
                case "dateAsc":
                    sortOrder = Sort.by("datePosted").ascending();
                    break;
                case "dateDesc":
                    sortOrder = Sort.by("datePosted").descending();
                    break;
            }
        }

        Pageable pageable = PageRequest.of(page, 12, sortOrder);
        Page<Product> productPage = productService.getProductsWithFilters(category, minPrice, maxPrice, region, pageable);
        long totalProducts = productService.countAllProducts();
        Map<String, Long> productCounts = productService.countProductsPerCategory();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String currentUsername = authentication.getName();
            User user = userRepository.findByEmail(currentUsername);

            if (user != null) {
                List<Product> recommendedProducts = recommendationService.getRecommendedProducts(user);
                model.addAttribute("recommendedProducts", recommendedProducts);
            }
        }

        model.addAttribute("productCounts", productCounts);
        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("currentCategory", category != null ? category : "");
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("currentSort", sort);
        model.addAttribute("currentRegion", region);
        model.addAttribute("noProductsFound", productPage.getTotalElements() == 0);
        model.addAttribute("totalProducts", totalProducts);

        return "shop";
    }

    @GetMapping("/activeList")
    public String showShopPage(Model model) {
        List<Product> activeProducts = productRepository.findByStatus("Available");
        model.addAttribute("products", activeProducts);
        return "shop";
    }

}


