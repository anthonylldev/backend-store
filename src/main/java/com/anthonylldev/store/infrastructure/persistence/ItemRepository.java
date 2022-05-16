package com.anthonylldev.store.infrastructure.persistence;

import com.anthonylldev.store.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByCategoryId(Long idCategory);
}
