package com.application.market.controller;

import  com.application.market.entity.Cart;
import com.application.market.entity.Product;
import com.application.market.entity.User;
import com.application.market.entity.UserActivity;
import com.application.market.repository.CartRepository;
import com.application.market.repository.ProductRepository;
import com.application.market.repository.UserActivityRepository;
import com.application.market.service.CartService;
import com.application.market.service.ProductService;
import com.application.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;
    @Autowired
    private UserActivityRepository userActivityRepository;


    @PostMapping("/addToCart")
    public ResponseEntity<?> addToCart(@RequestBody Map<String, Object> product) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());

        Cart cart = new Cart();

        Long productId = Long.valueOf(product.get("id").toString());

        Product foundProduct = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        cart.setProduct(foundProduct);

        cart.setUser(user);
        cart.setCategoryName((String) product.get("category"));
        cart.setBase64Image((String) product.get("image"));
        cart.setPrice(Double.valueOf(product.get("price").toString()));
        cart.setQuantity(Integer.parseInt(String.valueOf(1)));
        cart.setTitle((String) product.get("title"));
        cart.setTotal((Double)(cart.getPrice()*cart.getQuantity()));
        cart.setLocation(product.get("location").toString());

        cartRepository.save(cart);

        // Log the user's activity as 'CART'
        UserActivity activity = new UserActivity();
        activity.setUser(user);
        activity.setProduct(foundProduct);
        activity.setActivityType(UserActivity.ActivityType.CART);
        activity.setTimestamp(LocalDateTime.now());

        userActivityRepository.save(activity);
        return ResponseEntity.ok().body("Product added to cart successfully");
    }

    @PostMapping("/delete/{id}")
    public String deleteItemFromCart(@PathVariable("id") Long id) {
        // Logica pentru ștergerea produsului din coș
        cartRepository.deleteById(id);
        return "redirect:/cart"; // Redirectează către pagina coșului de cumpărături
    }

    @PostMapping("/cart/update-quantity/{id}")
    public String updateQuantity(@PathVariable(value="id") Long id, @RequestParam int quantity, Model model) {
        Cart cart = cartService.getCartById(id);

        Product product = cart.getProduct();

        // Verifică dacă există suficient stoc pentru produs
        if (quantity <= product.getQuantity()) {
            cartService.updateQuantity(id, quantity + 1);
            model.addAttribute("message", "Quantity updated successfully.");
        } else {
            model.addAttribute("error", "Not enough stock available.");
        }

        return "redirect:/cart"; // Redirecționează la pagina de coș
    }


}
