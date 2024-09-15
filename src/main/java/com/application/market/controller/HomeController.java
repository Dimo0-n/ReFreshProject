package com.application.market.controller;

import com.application.market.entity.Product;
import com.application.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public String home(Model model){
        model.addAttribute("page", "home");
        return "index";
    }

    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("page", "cart");
        return "cart";
    }

    @GetMapping("/shopDetail")
    public String shopDetails(Model model){
        model.addAttribute("page", "shopDetail");
        return "shopDetail";
    }

    @GetMapping("/checkout")
    public String chackout(Model model){
        model.addAttribute("page", "checkout");
        return "checkout";
    }

    @GetMapping("/testimonial")
    public String testimonial(Model model){
        model.addAttribute("page", "testimonial");
        return "testimonial";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("page", "contact");
        return "contact";
    }

    @GetMapping("/404")
    public String page404(Model model){
        model.addAttribute("page", "404");
        return "404";
    }

    @GetMapping("/addprod")
    public String addProduct(Model model){
        model.addAttribute("page", "addprod");
        return "addprod";
    }

}
