package dev.Tejveer.EcomProductService.Services;

import dev.Tejveer.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.Tejveer.EcomProductService.Entity.Product;

import java.util.List;

public interface ProductServices {
    List<FakeStoreProductResponseDTO> getAllProducts();
    FakeStoreProductResponseDTO getProduct(int productId);
    Product createProduct(Product product);
    Product updateProduct(Product product, int productId);
    boolean deleteProduct(int productId);
}
