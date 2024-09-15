package com.application.market.controller;

import com.application.market.entity.Cart;
import com.application.market.entity.Product;
import com.application.market.service.CartService;
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

    @Autowired
    private CartService cartService;

    @GetMapping("/index")
    public String home(Model model){
        model.addAttribute("page", "home");
        return "index";
    }

    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("page", "cart");
        List<Cart> cartItems = cartService.getAllCartsItems();
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @GetMapping("/shop")
    public String shop(@RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "category", defaultValue = "") String category,
                       Model model) {
        Pageable pageable = PageRequest.of(page, 12, Sort.by("datePosted").descending());
        Page<Product> productPage;

        long totalProducts = productService.countAllProducts();

        if (category.isEmpty()) {
            productPage = productService.getProducts(pageable);
        } else {
            productPage = productService.getProductsByCategory(category, pageable);
        }

        Map<String, Long> productCounts = productService.countProductsPerCategory();
        model.addAttribute("productCounts", productCounts);
        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("currentCategory", category);
        model.addAttribute("totalProducts", totalProducts);

        return "shop";
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
