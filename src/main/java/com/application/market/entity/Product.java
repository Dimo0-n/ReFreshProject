package com.application.market.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "categoryID", nullable = false)
    private Category category;

    private String title;
    private String description;
    private Double price;
    private String location;
    private Integer quantity;
    private String images;
    private LocalDateTime datePosted;
    private String status;

}