package dev.Tejveer.EcomProductService.Exception;

import dev.Tejveer.EcomProductService.Controller.CartController;
import dev.Tejveer.EcomProductService.DTO.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CartControllerException {

     @ExceptionHandler(CartNotFoundException.class)
     public ResponseEntity handleCartNotFoundException (CartNotFoundException ce){
          ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(ce.getMessage(), 400);
          return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
     }

     @ExceptionHandler(RandomException.class)
     public ResponseEntity handleCartRandomException (RandomException re){
          ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(re.getMessage(), 400);
          return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
     }
}
