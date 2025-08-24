package dev.Tejveer.EcomProductService.Entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@Entity(name = "Products")
public class Product extends BaseModel {
    private String title;
    private String description;
    private String category;
    private double price;
    private String imageUrl;
    private double rating;
}
