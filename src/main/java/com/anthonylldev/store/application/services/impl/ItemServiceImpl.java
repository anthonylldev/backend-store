package com.anthonylldev.store.application.services.impl;

import com.anthonylldev.store.application.dto.ItemDto;
import com.anthonylldev.store.application.mapper.ItemMapper;
import com.anthonylldev.store.application.services.ItemService;
import com.anthonylldev.store.domain.entity.Item;
import com.anthonylldev.store.domain.persistence.ItemPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemPersistence itemPersistence;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemServiceImpl(ItemPersistence itemPersistence, ItemMapper itemMapper) {
        this.itemPersistence = itemPersistence;
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> items = this.itemPersistence.getAllItems();
        return this.itemMapper.toDto(items);
    }

    @Override
    public List<ItemDto> getAllItemsByCategory(Long categoryId) {
        List<Item> items = this.itemPersistence.getAllItemsByCategory(categoryId);
        return this.itemMapper.toDto(items);
    }

    @Override
    public Optional<ItemDto> getItemById(Long itemId) {
        return this.itemPersistence
                .getItemById(itemId)
                .map(this.itemMapper::toDto);
    }

    @Override
    public ItemDto saveItem(ItemDto itemDto) {
        Item item = this.itemPersistence.saveItem(
                this.itemMapper.toEntity(itemDto)
        );

        return this.itemMapper.toDto(item);
    }

    @Override
    public void deleteItem(Long itemId) {
        this.itemPersistence.deleteItem(itemId);
    }
}
