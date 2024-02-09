package am.itspace.eshopspring.service;

import am.itspace.eshopspring.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    Product findById(int id);
}
