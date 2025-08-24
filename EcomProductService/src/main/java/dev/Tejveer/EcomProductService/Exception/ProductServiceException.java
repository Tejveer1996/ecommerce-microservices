package dev.Tejveer.EcomProductService.Exception;

import dev.Tejveer.EcomProductService.Controller.ProductController;
import dev.Tejveer.EcomProductService.DTO.ExceptionResponseDTO;
import dev.Tejveer.EcomProductService.Exception.InvalidProductIdException;
import dev.Tejveer.EcomProductService.Exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceException {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity handleProductNotFoundException(ProductNotFoundException pe){
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(pe.getMessage(), 404);
        return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity handleInvalidProductIdException(InvalidProductIdException pe){
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(pe.getMessage(), 400);
        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RandomException.class)
    public ResponseEntity handleProductRandomException (RandomException re){
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(re.getMessage(), 400);
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }
}
