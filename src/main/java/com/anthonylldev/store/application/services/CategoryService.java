package com.anthonylldev.store.application.services;

import com.anthonylldev.store.application.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    Optional<CategoryDto> getCategoryById(Long categoryId);
    CategoryDto saveCategory(CategoryDto categoryDto);
    void deleteCategory(Long categoryId);
}
