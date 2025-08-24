package dev.Tejveer.EcomProductService.Controller;

import dev.Tejveer.EcomProductService.Client.FakeStoreClient;
import dev.Tejveer.EcomProductService.DTO.FakeStoreCartDTO;
import dev.Tejveer.EcomProductService.Exception.CartNotFoundException;
import dev.Tejveer.EcomProductService.Exception.RandomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private FakeStoreClient fakeStoreClient;

    @GetMapping("/cart/{userId}")
    public ResponseEntity getCartById (@PathVariable ("userId") int userId){
        List<FakeStoreCartDTO> listOfCart = fakeStoreClient.getCartById(userId);
        if (listOfCart == null){
            throw new CartNotFoundException("Invalid userId");
        }
        return ResponseEntity.ok(listOfCart);
    }

    @GetMapping("/cartException")
    public ResponseEntity cartException(){
        throw new RandomException("Exception from the cart");
    }
}
