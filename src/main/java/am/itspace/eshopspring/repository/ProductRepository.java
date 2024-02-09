package am.itspace.eshopspring.repository;

import am.itspace.eshopspring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
