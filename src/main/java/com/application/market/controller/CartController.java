package com.application.market.controller;

import com.application.market.entity.Cart;
import com.application.market.entity.Product;
import com.application.market.entity.User;
import com.application.market.repository.CartRepository;
import com.application.market.service.CartService;
import com.application.market.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/addToCart")
    public ResponseEntity<?> addToCart(@RequestBody Product product) {

        //Trebuie sa fac ca sa se salveze si user_id cu category in baza de date

        Cart cart = new Cart();

        cart.setBase64Image(product.getBase64Image());
        cart.setPrice(product.getPrice());
        cart.setQuantity(product.getQuantity());
        cart.setTitle(product.getTitle());

        cartRepository.save(cart);
        return ResponseEntity.ok().body("Product added to cart successfully");
    }

}
