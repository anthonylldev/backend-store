package com.anthonylldev.store.infrastructure.persistence;

import com.anthonylldev.store.domain.entity.Category;
import com.anthonylldev.store.domain.persistence.CategoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryPersistenceImpl implements CategoryPersistence {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryPersistenceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long categoryId) {
        return this.categoryRepository.findById(categoryId);
    }

    @Override
    public Category saveCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }
}
