package com.application.market.controller;

import com.application.market.entity.Cart;
import com.application.market.entity.Product;
import com.application.market.entity.User;
import com.application.market.repository.CartRepository;
import com.application.market.service.CartService;
import com.application.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/addToCart")
    public ResponseEntity<?> addToCart(@RequestBody Map<String, Object> product) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());

        Cart cart = new Cart();

        cart.setUser(user);
        cart.setCategoryName((String) product.get("category"));
        cart.setBase64Image((String) product.get("image"));
        cart.setPrice(Double.valueOf(product.get("price").toString()));
        cart.setQuantity(Integer.parseInt(String.valueOf(1)));
        cart.setTitle((String) product.get("title"));
        cart.setTotal((Double)(cart.getPrice()*cart.getQuantity()));
        cart.setLocation(product.get("location").toString());

        cartRepository.save(cart);
        return ResponseEntity.ok().body("Product added to cart successfully");
    }

    @PostMapping("/delete/{id}")
    public String deleteItemFromCart(@PathVariable("id") Long id) {
        // Logica pentru ștergerea produsului din coș
        cartRepository.deleteById(id);
        return "redirect:/cart"; // Redirectează către pagina coșului de cumpărături
    }


}
