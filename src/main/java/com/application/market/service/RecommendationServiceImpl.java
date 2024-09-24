package com.application.market.service;

import com.application.market.entity.Category;
import com.application.market.entity.Product;
import com.application.market.entity.User;
import com.application.market.entity.UserActivity;
import com.application.market.repository.ProductRepository;
import com.application.market.repository.UserActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService{

    @Autowired
    private UserActivityRepository userActivityRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getRecommendedProducts(User user) {
        List<UserActivity> userActivities = userActivityRepository.findByUserOrderByTimestampDesc(user);

        if (userActivities.isEmpty()) {
            return productRepository.findAllByOrderByDatePostedDesc()
                    .stream().limit(20).collect(Collectors.toList());
        }

        // Step 1: Collect categories and keywords based on user activity
        Map<Category, Integer> categoryFrequency = new HashMap<>();
        Set<String> keywords = new HashSet<>();

        for (UserActivity activity : userActivities) {
            Product product = activity.getProduct();
            categoryFrequency.merge(product.getCategory(), 1, Integer::sum);
            keywords.addAll(Arrays.asList(product.getTitle().split(" ")));
        }

        // Step 2: Get all products, categorized by their category and sorted by price
        List<Product> allProducts = productRepository.findAll();

        Map<Category, List<Product>> categorizedProducts = allProducts.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        // Step 3: Randomize and select products from different categories and price ranges
        List<Product> recommendedProducts = new ArrayList<>();

        Random rand = new Random();

        while (recommendedProducts.size() < 20 && !categorizedProducts.isEmpty()) {
            for (Map.Entry<Category, Integer> entry : categoryFrequency.entrySet()) {
                Category category = entry.getKey();
                List<Product> productsInCategory = categorizedProducts.get(category);

                if (productsInCategory != null && !productsInCategory.isEmpty()) {
                    // Mix in price criteria
                    productsInCategory.sort(Comparator.comparing(Product::getPrice));

                    // Randomly pick a product from this category
                    Product selectedProduct = productsInCategory.remove(rand.nextInt(productsInCategory.size()));
                    recommendedProducts.add(selectedProduct);

                    if (productsInCategory.isEmpty()) {
                        categorizedProducts.remove(category); // Remove category when empty
                    }
                }
            }
        }

        return recommendedProducts.stream().distinct().limit(20).collect(Collectors.toList());
    }

}
