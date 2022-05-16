package com.anthonylldev.store.domain.persistence;

import com.anthonylldev.store.domain.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemPersistence {

    List<Item> getAllItemsByCategory(Long idCategory);
    Optional<Item> getItemById(Long idItem);
    Item saveItem(Item item);
    void deleteItem(Long idItem);
}
