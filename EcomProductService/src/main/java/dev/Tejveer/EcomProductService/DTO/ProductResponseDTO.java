package dev.Tejveer.EcomProductService.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private int productID;
    private String title;
    private String description;
    private String category;
    private double price;
    private String imageUrl;
    private double rating;
}
