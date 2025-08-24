package dev.Tejveer.EcomProductService.Controller;

import dev.Tejveer.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.Tejveer.EcomProductService.DTO.ProductResponseDTO;
import dev.Tejveer.EcomProductService.Entity.Product;
import dev.Tejveer.EcomProductService.Exception.InvalidProductIdException;
import dev.Tejveer.EcomProductService.Exception.RandomException;
import dev.Tejveer.EcomProductService.Services.FakeStoreProductServices;
import dev.Tejveer.EcomProductService.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Qualifier("ProductService")
    @Autowired
    private ProductServices productServices;
    @Autowired
    private FakeStoreProductServices fakeStoreProductServices;

    @GetMapping("/products")
    public ResponseEntity<List<FakeStoreProductResponseDTO>>  getAllProducts(){
        List<FakeStoreProductResponseDTO> products = productServices.getAllProducts();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/fakeStoreProducts")
    public ResponseEntity<List<FakeStoreProductResponseDTO>>  getAllFakeStoreProducts(){
        List<FakeStoreProductResponseDTO> products = fakeStoreProductServices.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id){
        if (id<1){
            throw new InvalidProductIdException("Invalid productId");
        }
        FakeStoreProductResponseDTO product = productServices.getProduct(id);
        return ResponseEntity.ok(product);
    }


    @GetMapping("/productException")
    public ResponseEntity cartException(){
        throw new RandomException("Exception from the product");
    }

    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody Product product){
        Product savedProduct = productServices.createProduct(product);
        return ResponseEntity.ok(savedProduct);
    }
}
