package dev.Tejveer.EcomProductService.Repository;

import dev.Tejveer.EcomProductService.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
