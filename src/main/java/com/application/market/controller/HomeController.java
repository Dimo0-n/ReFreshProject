package com.application.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("page", "home");
        return "index";
    }

    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("page", "cart");
        return "cart";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("page", "shop");
        return "shop";
    }

    @GetMapping("/shopDetail")
    public String shopDetails(Model model){
        model.addAttribute("page", "shopDetail");
        return "shopDetail";
    }

    @GetMapping("/chackout")
    public String chackout(Model model){
        model.addAttribute("page", "chackout");
        return "chackout";
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

}
