package com.application.market.controller;

import com.application.market.entity.Cart;
import com.application.market.entity.Product;
import com.application.market.entity.User;
import com.application.market.service.CartService;
import com.application.market.service.ProductService;
import com.application.market.service.UserService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String home(Model model){
        model.addAttribute("page", "home");
        return "index";
    }

    @GetMapping("/cart")
    public String cart(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());

        Long id = user.getId();

        model.addAttribute("page", "cart");
        List<Cart> cartItems = cartService.getCartsItemsByUserId(id);
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

//    @GetMapping("/shopDetail")
//    public String shopDetails(Model model){
//        model.addAttribute("page", "shopDetail");
//        return "shopDetail";
//    }

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
