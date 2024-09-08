package com.Ecommerce.Ecommerce.application.Service.Category;

import com.Ecommerce.Ecommerce.application.dto.category.CategoryDto;
import com.Ecommerce.Ecommerce.domain.model.Category.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICategoryService {
    Category createCategory(CategoryDto request);
    Category getCategoryById(UUID id);
    void deleteCategoryById(UUID id);
    Category updateCategory(UUID id,CategoryDto request);
    List<Category> findAll();
}
