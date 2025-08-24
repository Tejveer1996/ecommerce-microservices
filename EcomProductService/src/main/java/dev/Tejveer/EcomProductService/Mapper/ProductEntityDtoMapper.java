package dev.Tejveer.EcomProductService.Mapper;

import dev.Tejveer.EcomProductService.DTO.ProductResponseDTO;
import dev.Tejveer.EcomProductService.Entity.Product;

public class ProductEntityDtoMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDto(Product product){
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        responseDTO.setTitle(product.getTitle());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setCategory(product.getCategory());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setImageUrl(product.getImageUrl());
        responseDTO.setRating(product.getRating());

        return responseDTO;
    }
}
