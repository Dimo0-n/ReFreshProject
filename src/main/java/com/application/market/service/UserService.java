package com.application.market.service;

import com.application.market.dto.UserDto;
import com.application.market.entity.Profile;
import com.application.market.entity.User;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

public interface UserService{

    User findByEmail(String email);

    void saveUser(@Valid UserDto userDto);

    Profile getUserInfo(String email);

    void deleteUserById(Long id);

    @Transactional
    void updatePassword(User user, String newPassword);

}
