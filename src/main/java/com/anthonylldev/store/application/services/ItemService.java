package com.anthonylldev.store.application.services;

import com.anthonylldev.store.application.dto.ItemDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<ItemDto> getAllItems();
    List<ItemDto> getAllItemsByCategory(Long categoryId);
    Optional<ItemDto> getItemById(Long itemId);
    ItemDto saveItem(ItemDto itemDto);
    void deleteItem(Long itemId);
}
