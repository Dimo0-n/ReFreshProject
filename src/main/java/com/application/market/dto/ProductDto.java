package com.application.market.dto;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;
    @NotEmpty
    private String title;
    private String description;
    @NotEmpty
    private Double price;
    @NotEmpty
    private Integer quantity;
    private String location;
    @NotEmpty
    private String category;
    private String base64Image;
}
