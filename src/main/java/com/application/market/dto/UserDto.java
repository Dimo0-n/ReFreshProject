package com.application.market.dto;

import com.application.market.entity.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {

    private Long userID;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String password;

    @ManyToOne
    @JoinColumn(name = "roleID", nullable = false)
    private Role role;

    private LocalDateTime registerDate;
    private LocalDateTime lastLoginDate;
    private String userType;
    private String profilePicture;
}
