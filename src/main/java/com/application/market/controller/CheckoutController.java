package com.application.market.controller;

import com.application.market.entity.Cart;
import com.application.market.entity.Checkout;
import com.application.market.entity.User;
import com.application.market.service.CartService;
import com.application.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CheckoutController {

    @Autowired
    private CartService cartService;

    @GetMapping("/purchase{id}")
    public String showCheckoutPage(@PathVariable Long id, Model model) {
        // Preluarea articolelor din coș după id-ul coșului
        Cart cart = cartService.getCartById(id);

        if (cart != null) {
            model.addAttribute("cart", cart);
        } else return "redirect:/404";

        return "checkout"; // Redirecționarea către pagina de checkout
    }
}
