package com.anthonylldev.store.application.mapper;

import com.anthonylldev.store.application.dto.ItemDto;
import com.anthonylldev.store.domain.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper extends EntityMapper<ItemDto, Item> {


    @Override
    @Mapping(source = "categoryId", target = "category")
    Item toEntity(ItemDto dto);

    @Override
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    ItemDto toDto(Item entity);
}
