package am.itspace.eshopspring.service.impl;

import am.itspace.eshopspring.entity.Category;
import am.itspace.eshopspring.repository.CategoryRepository;
import am.itspace.eshopspring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
