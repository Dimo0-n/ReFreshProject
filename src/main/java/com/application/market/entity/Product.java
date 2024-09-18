package com.application.market.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Base64;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "location")
    private String location;

    @Column(name = "quantity")
    private Integer quantity;

    @Lob
    @Column(name = "images", columnDefinition = "LONGBLOB")
    private byte[] image;

    public String getBase64Image() {
        if (this.image != null) {
            return Base64.getEncoder().encodeToString(this.image);
        }
        return null;
    }

    public void setBase64Image(String base64Image) {
        if (base64Image != null) {
            this.image = Base64.getDecoder().decode(base64Image);
        } else {
            this.image = null;
        }
    }

    @Column(name = "datePosted")
    private LocalDateTime datePosted;

    @Column(name = "status")
    private String status;

    public Product(User user, Category category, String title, String description, Double price, String location, Integer quantity, byte[] image, LocalDateTime datePosted, String status) {
        this.user = user;
        this.category = category;
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
        this.quantity = quantity;
        this.image = image;
        this.datePosted = datePosted;
        this.status = status;
    }

    public String getName() {
        return title;
    }
}
