package com.application.market.controller;

import com.application.market.dto.UserDto;
import com.application.market.entity.Profile;
import com.application.market.entity.User;
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

    @GetMapping("/profil")
    public String showProfile(Model model, Authentication auth) {

        Profile profile = userService.getUserInfo(auth.getName());

        model.addAttribute("page", "profile");
        model.addAttribute("profile", profile);

        return "profile";
    }

    @PostMapping("/profil/update")
    public String updateProfile(Model model) {

        return "redirect:/profil";
    }

}
