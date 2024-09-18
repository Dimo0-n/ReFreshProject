package com.application.market.controller;

import com.application.market.entity.Cart;
import com.application.market.entity.User;
import com.application.market.service.CartService;
import com.application.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CheckoutController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @GetMapping("/checkout")
    public String chackout(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());

        Long id = user.getId();
        Double total = cartService.getTotalPrice();

        model.addAttribute("page", "checkout");
        List<Cart> cartItems = cartService.getCartsItemsByUserId(id);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", total);
        return "checkout";
    }

}
