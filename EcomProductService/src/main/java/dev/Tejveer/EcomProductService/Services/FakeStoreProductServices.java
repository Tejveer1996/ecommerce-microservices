package dev.Tejveer.EcomProductService.Services;

import dev.Tejveer.EcomProductService.Client.FakeStoreClient;
import dev.Tejveer.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.Tejveer.EcomProductService.Entity.Product;
import dev.Tejveer.EcomProductService.Exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FakeProductService")
public class FakeStoreProductServices implements ProductServices{
    @Autowired
    private FakeStoreClient fakeStoreClient;
    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
        return fakeStoreProducts;
    }

    @Override
    public FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException{
        FakeStoreProductResponseDTO responseDTO = fakeStoreClient.getProductById(productId);
        if (responseDTO == null){
            throw new ProductNotFoundException("Product not found for the productId : "+productId);
        }
        return responseDTO;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
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
