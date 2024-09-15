package com.application.market.service;

import com.application.market.dto.UserDto;
import com.application.market.entity.Profile;
import com.application.market.entity.User;
import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

public interface UserService{

    User findByEmail(String email);

//    void updateUserProfile(Profile profile);

    void saveUser(@Valid UserDto userDto);

    Profile getUserInfo(String email);

    void deleteUserById(Long id);

//    Profile getUserInfo(String name);
}
