package com.Ecommerce.Ecommerce.domain.repository.Category;

import com.Ecommerce.Ecommerce.domain.model.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID>,IBaseCategoryRepository {
}
