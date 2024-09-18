package com.application.market.controller;

import com.application.market.dto.ProductDto;
import com.application.market.entity.Category;
import com.application.market.entity.Product;
import com.application.market.repository.CategoryRepository;
import com.application.market.repository.ProductRepository;
import com.application.market.repository.UserRepository;
import com.application.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/addproduct")
    public String showProductForm(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "addprod";
    }

    @GetMapping("/shopDetail-{id}")
    public String getProductDetails(@PathVariable("id") Long id, Model model) {
        Product product = productService.findProductById(id);

        if (product != null) {
            model.addAttribute("page", "shopDetail");
            model.addAttribute("product", product);
//
//            // Fetch related products from the same category (limit 5)
//            List<Product> relatedProducts = productService.getTop5ProductsByCategory(product.getCategory().getCategoryName());
//            model.addAttribute("relatedProducts", relatedProducts);

            return "shopDetail";
        } else {
            model.addAttribute("errorMessage", "Product not found");
            return "404";
        }
    }

    @PostMapping("/submit-product")
    public String submitProduct(@ModelAttribute ProductDto productDto,
                                @RequestParam("imageFile") MultipartFile imageFile,
                                RedirectAttributes redirectAttributes) {
        try {
            if (imageFile.getSize() > 10485760) { // 10 MB size limit
                throw new IllegalStateException("File size too large");
            }
            productService.saveProduct(productDto, imageFile);
            redirectAttributes.addFlashAttribute("productAdded", true);
            return "redirect:/shop?productAdded=true";
        } catch (IllegalStateException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "File size exceeds the 10MB limit.");
            return "redirect:/addproduct?error=fileTooLarge";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error uploading product.");
            return "redirect:/addproduct?error=true";
        }
    }

    @GetMapping("/editProduct-{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.findProductById(id);

        if (product != null) {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setTitle(product.getTitle());
            productDto.setDescription(product.getDescription());
            productDto.setPrice(product.getPrice());
            productDto.setQuantity(product.getQuantity());
            productDto.setLocation(product.getLocation());
            productDto.setCategory(product.getCategory().getCategoryName());

            model.addAttribute("productDto", productDto);
            return "editProductForm";
        } else {
            model.addAttribute("errorMessage", "Product not found");
            return "404";
        }
    }

    @PostMapping("/update-product")
    public String updateProduct(@ModelAttribute ProductDto productDto,
                                @RequestParam("imageFile") MultipartFile imageFile,
                                RedirectAttributes redirectAttributes) {
        try {
            productService.updateProduct(productDto, imageFile);
            redirectAttributes.addFlashAttribute("productUpdated", true);
            return "redirect:/shopDetail-" + productDto.getId();
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error updating product.");
            return "redirect:/editproduct-" + productDto.getId() + "?error=true";
        }
    }
}