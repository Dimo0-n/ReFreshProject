package com.application.market.config;

import com.application.market.entity.Category;
import com.application.market.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import java.util.List;

@Component
public class DataInitializer {

    private final CategoryRepository categoryRepository;

    public DataInitializer(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    public void init() {
        // Listă de categorii pe care vrei să le adaugi
        List<String> categories = List.of(
                "Metals", "Battery Recycling", "Compost & Food Waste",
                "Computer & Electronics", "Glass & Fiberglass",
                "Chemicals", "Paper/Cardboard", "Plastic",
                "Textiles & Leather", "Tire & Rubber", "Wood",
                "Used Commercial Goods", "Used Clothes", "Used Equipment"
        );

        // Adăugarea categoriilor dacă nu există deja
        categories.forEach(categoryName -> {
            if (!categoryRepository.existsByCategoryName(categoryName)) {
                categoryRepository.save(new Category((long) (categories.size()), categoryName));
            }
        });
    }
}
