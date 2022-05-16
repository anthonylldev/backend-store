package com.anthonylldev.store.application.services.impl;

import com.anthonylldev.store.application.dto.CategoryDto;
import com.anthonylldev.store.application.mapper.CategoryMapper;
import com.anthonylldev.store.application.services.CategoryService;
import com.anthonylldev.store.domain.entity.Category;
import com.anthonylldev.store.domain.persistence.CategoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryPersistence categoryPersistence;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryPersistence categoryPersistence, CategoryMapper categoryMapper) {
        this.categoryPersistence = categoryPersistence;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryPersistence.getAllCategories();
        return this.categoryMapper.toDto(categories);
    }

    @Override
    public Optional<CategoryDto> getCategoryById(Long categoryId) {
        return this.categoryPersistence
                .getCategoryById(categoryId)
                .map(this.categoryMapper::toDto);
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = this.categoryPersistence.saveCategory(
                this.categoryMapper.toEntity(categoryDto)
        );

        return this.categoryMapper.toDto(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        this.categoryPersistence.deleteCategory(categoryId);
    }
}
