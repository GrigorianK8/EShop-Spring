package am.itspace.eshopspring.service;

import am.itspace.eshopspring.entity.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    List<Category> findAll();
}
