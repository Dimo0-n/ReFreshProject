package com.application.market.dto;

import com.application.market.entity.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String username;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String password;

    private List<String> roles;

    private LocalDateTime registerDate;

    private LocalDateTime lastLoginDate;

    private String userType;

    private byte[] image;
}
