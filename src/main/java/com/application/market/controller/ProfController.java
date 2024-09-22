package com.application.market.controller;

import com.application.market.entity.Product;
import com.application.market.entity.Profile;
import com.application.market.entity.User;
import com.application.market.service.ProductService;
import com.application.market.service.ProfileService;
import com.application.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class ProfController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProductService productService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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
                                Authentication auth,
                                RedirectAttributes redirectAttributes) {
        try {
            if (!profileImage.isEmpty()) {
                addedProfile.setImage(profileImage.getBytes());  // Salvează imaginea ca byte[]
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        redirectAttributes.addFlashAttribute("successMessage", "Changes saved successfully!");

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

    @GetMapping("/change-password")
    public String changePasssword() {
        return "change-password";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestParam String currentPassword,
                                 @RequestParam String newPassword,
                                 Principal principal,
                                 Model model) {
        User user = userService.findByEmail(principal.getName());

        if (passwordEncoder.matches(currentPassword, user.getPassword())) {
            if (!newPassword.equals(currentPassword)) {
                user.setPassword(passwordEncoder.encode(newPassword));
                userService.updatePassword(user, newPassword);
                model.addAttribute("success", "Password changed successfully.");
                return "change-password";
            } else {
                model.addAttribute("error", "The new password cannot be the same as the current password.");
            }
        } else {
            model.addAttribute("error", "The current password is incorrect.");
        }

        return "change-password";
    }

    @GetMapping("/purchase-history")
    public String purchaseHistory() {
        return "profile-purchase-history";
    }

}
