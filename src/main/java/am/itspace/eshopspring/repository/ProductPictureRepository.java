package am.itspace.eshopspring.repository;

import am.itspace.eshopspring.entity.Product;
import am.itspace.eshopspring.entity.ProductPicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductPictureRepository extends JpaRepository<ProductPicture, Integer> {

    List<ProductPicture> findAllByProduct(Product product);
}
