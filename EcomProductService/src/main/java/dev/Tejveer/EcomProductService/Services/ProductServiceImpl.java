package dev.Tejveer.EcomProductService.Services;

import dev.Tejveer.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.Tejveer.EcomProductService.Entity.Product;
import dev.Tejveer.EcomProductService.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductServices{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        return null;
    }

    @Override
    public FakeStoreProductResponseDTO getProduct(int productId) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product product, int productId) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }
}
