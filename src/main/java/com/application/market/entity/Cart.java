package com.application.market.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Base64;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "title")
    private String title;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    @Column(name = "total")
    private Double total;

    @Lob
    @Column(name = "images",  columnDefinition = "LONGBLOB")
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

}