package com.application.market.controller;

import com.application.market.dto.ProductDto;
import com.application.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/addproduct")
    public String showProductForm(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "addprod";
    }

    @PostMapping("/submit-product")
    public String submitProduct(@ModelAttribute ProductDto productDto,
                                @RequestParam("imageFile") MultipartFile imageFile,
                                Model model) {
        try {
            productService.saveProduct(productDto, imageFile);
            model.addAttribute("successMessage", "Product added successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error uploading product");
        }
        return "redirect:/addprod";
    }

}
