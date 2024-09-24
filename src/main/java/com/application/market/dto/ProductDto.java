package com.application.market.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;

    @NotEmpty
    private String title;

    @Size(max = 65535)
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
