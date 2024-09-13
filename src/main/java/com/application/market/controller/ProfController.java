package com.application.market.controller;

import com.application.market.entity.Profile;
import com.application.market.service.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfController {

    @Autowired
    private ProfileServiceImpl profileService;

    @GetMapping("/profile")
    public String showProfile(Model model) {

//        Profile profile = profileService.findById(id);

//        if (profile != null) {
//            model.addAttribute("profile", profile);
//            return "profile";
//        } else
//            return "redirect:/404";

        return "profile";

    }

}
