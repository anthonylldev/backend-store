package com.anthonylldev.store.application.mapper;

import com.anthonylldev.store.application.dto.CategoryDto;
import com.anthonylldev.store.domain.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDto, Category> {

    default Category fromId(Long id) {
        if (id == null) return null;
        Category category = new Category();
        category.setId(id);
        return category;
    }
}
