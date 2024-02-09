package am.itspace.eshopspring.repository;

import am.itspace.eshopspring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
