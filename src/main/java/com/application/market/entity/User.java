package com.application.market.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String passwordHash;

    @ManyToOne
    @JoinColumn(name = "roleID", nullable = false)
    private Role role;

    private LocalDateTime registerDate;
    private LocalDateTime lastLoginDate;
    private String userType;
    private String profilePicture;

}

