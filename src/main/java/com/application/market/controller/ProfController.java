package com.application.market.controller;

import com.application.market.dto.UserDto;
import com.application.market.entity.Profile;
import com.application.market.entity.User;
import com.application.market.service.ProfileService;
import com.application.market.service.UserService;
import com.application.market.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Controller
public class ProfController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profile")
    public String showProfile(Model model, Authentication auth) {

        Profile profile = userService.getUserInfo(auth.getName());

        model.addAttribute("page", "profile");
        model.addAttribute("profile", profile);

        return "profile";
    }

    @PostMapping("/update")
    public String updateProfil(@ModelAttribute Profile addedProfile, Authentication auth) {
        profileService.updateProfil(auth.getName(), addedProfile);
        System.out.println(auth.getName());
        return "redirect:/profile";
    }

    @GetMapping("/profile-articles")
    public String profileArticles() {
        return "profile-articles";
    }

    @GetMapping("/profile-sales")
    public String profileSales() {
        return "profile-sales";
    }
}

