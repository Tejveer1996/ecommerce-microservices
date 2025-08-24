package dev.Tejveer.EcomProductService.Client;

import dev.Tejveer.EcomProductService.DTO.FakeStoreCartDTO;
import dev.Tejveer.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.Tejveer.EcomProductService.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakeStore.api.base.url}")   // this annotation fetch the required url from the app. properties.
    private String fakeStoreAPIBaseURl;
    @Value(("${fakeStore.api.products.path}"))
    private String fakeStoreAPIProductPath;
    @Value(("${fakeStore.api.cart.path}"))
    private String fakeStoreAPICartPath;

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String fakeStoreProductURl = fakeStoreAPIBaseURl.concat(fakeStoreAPIProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> responseEntity = restTemplate.
                getForEntity(fakeStoreProductURl,FakeStoreProductResponseDTO[].class);
                // return the entity by converting JSON to an object
        return List.of(responseEntity.getBody());
    }

    public FakeStoreProductResponseDTO getProductById(int id){
        // url -> https://fakestoreapi.com/product/id
        String fakeStoreProductUrl = fakeStoreAPIBaseURl.concat(fakeStoreAPIProductPath).concat("/"+id);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> responseEntity = restTemplate.
                                    getForEntity(fakeStoreProductUrl,FakeStoreProductResponseDTO.class);
        return responseEntity.getBody();
    }

    public List<FakeStoreCartDTO> getCartById(int userId){
          // https://fakestoreapi.com/carts?userId=1
        if (userId <1){
            return null;
        }
        String fakeStoreCartUrl = fakeStoreAPIBaseURl.concat(fakeStoreAPICartPath).concat(String.valueOf(userId));
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartDTO[]> responseEntity = restTemplate.
                getForEntity(fakeStoreCartUrl,FakeStoreCartDTO[].class);
        return List.of(responseEntity.getBody());
    }
}
