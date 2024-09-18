package com.application.market.controller;

import com.application.market.dto.UserDto;
import com.application.market.entity.Product;
import com.application.market.entity.Profile;
import com.application.market.entity.User;
import com.application.market.service.ProductService;
import com.application.market.service.ProfileService;
import com.application.market.service.UserService;
import com.application.market.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class ProfController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProductService productService;

    @GetMapping("/profile")
    public String showProfileGeneral(Model model, Authentication auth) {
        Profile profile = userService.getUserInfo(auth.getName());
        model.addAttribute("profile", profile);
        return "profile-general";
    }

    @GetMapping("/profile-settings")
    public String showProfileSettings(Model model, Authentication auth) {
        Profile profile = userService.getUserInfo(auth.getName());
        model.addAttribute("profile", profile);
        return "profile-settings";
    }

    @GetMapping("/profile-general")
    public String profileGeneral(Model model, Authentication auth) {
        Profile profile = userService.getUserInfo(auth.getName());
        if (profile == null) {
            return "error";
        }
        model.addAttribute("profile", profile);
        return "profile-general";
    }

    @PostMapping("/update")
    public String updateProfile(@ModelAttribute Profile addedProfile,
                                @RequestParam("profileImage") MultipartFile profileImage,
                                Authentication auth) {
        try {
            if (!profileImage.isEmpty()) {
                addedProfile.setImage(profileImage.getBytes());  // Salvează imaginea ca byte[]
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        profileService.updateProfil(auth.getName(), addedProfile);
        return "redirect:/profile-settings";
    }


    @GetMapping("/profile-articles")
    public String profileArticles(Model model, Authentication auth) {

        Profile profile = userService.getUserInfo(auth.getName());

        List<Product> userProducts = productService.getProductsByUserSortedByDate(profile.getUser());

        model.addAttribute("profile", profile);
        model.addAttribute("products", userProducts);

        return "profile-articles";
    }



    @GetMapping("/profile-sales")
    public String profileSales() {
        return "profile-sales";
    }

}


