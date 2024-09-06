package com.application.market.controller;


import com.application.market.dto.UserDto;
import com.application.market.entity.User;
import com.application.market.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/register")
        public String showRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
//        model.addAtribute("user", userDto);
        return "register";
        }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {

    User existingUser = userService.findByEmail(userDto.getEmail());

      if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null, "There is already an account registered with that email");
    }
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "redirect:/register?error";
    }
        userService.saveUser(userDto);
        return "redirect:/register?success";
}

}