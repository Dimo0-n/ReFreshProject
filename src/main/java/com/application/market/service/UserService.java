package com.application.market.service;

import com.application.market.dto.UserDto;
import com.application.market.entity.User;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService{

    User findByEmail(String email);


    void saveUser(@Valid UserDto userDto);

    List<UserDto> findAllUsers();

}
