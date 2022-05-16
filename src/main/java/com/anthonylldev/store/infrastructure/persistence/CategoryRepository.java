package com.anthonylldev.store.infrastructure.persistence;

import com.anthonylldev.store.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
