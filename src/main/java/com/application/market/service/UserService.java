package com.application.market.service;

import com.application.market.dto.UserDto;
import com.application.market.entity.User;
import jakarta.validation.Valid;

public interface UserService{

    User findByEmail(String email);

    void saveUser(@Valid UserDto userDto);

    void deleteUserById(Long id);
}
