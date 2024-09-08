package com.Ecommerce.Ecommerce.application.Service.Category;

import com.Ecommerce.Ecommerce.application.dto.category.CategoryDto;
import com.Ecommerce.Ecommerce.application.exception.ResourceNotFoundException;
import com.Ecommerce.Ecommerce.domain.model.Category.Category;
import com.Ecommerce.Ecommerce.domain.repository.Category.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Qualifier("japCategoryService")
public class CategoryService implements ICategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(CategoryDto request) {
        Category newCategory=new Category();
        newCategory.setName(request.name);
        newCategory.setDescription(request.description);

        return this.categoryRepository.save(newCategory);
    }

    @Override
    public Category getCategoryById(UUID id) {
        return this.categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category Not Found"));

    }


    @Override
    public void deleteCategoryById(UUID id) {
        this.categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category to be deleted Not Found"));
        this.categoryRepository.deleteById(id);

    }

    @Override
    public Category updateCategory(UUID id,CategoryDto request) {
        Category existingCategory=this.categoryRepository.findById(id).orElseThrow(()->new Error("Category Not Found"));
        existingCategory.setName(request.name);
        existingCategory.setDescription(request.description);
        return this.categoryRepository.save(existingCategory);

    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();

    }
}
