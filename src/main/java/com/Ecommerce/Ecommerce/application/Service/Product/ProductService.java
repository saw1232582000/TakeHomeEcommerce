package com.Ecommerce.Ecommerce.application.Service.Product;

import com.Ecommerce.Ecommerce.application.dto.product.ProductDto;
import com.Ecommerce.Ecommerce.application.exception.ResourceNotFoundException;
import com.Ecommerce.Ecommerce.domain.model.Category.Category;
import com.Ecommerce.Ecommerce.domain.model.Product.Product;
import com.Ecommerce.Ecommerce.domain.model.Product.Product;
import com.Ecommerce.Ecommerce.domain.repository.Category.CategoryRepository;
import com.Ecommerce.Ecommerce.domain.repository.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements IBaseProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(ProductDto request) {
        Product newProduct=new Product();
        Category category= this.categoryRepository.findById(request.categoryId).orElseThrow(()->new ResourceNotFoundException("Category not found"));
        newProduct.setCategory(category);
        newProduct.setName(request.name);
        newProduct.setSku(request.sku);
        newProduct.setPrice(request.price);
        newProduct.setDescription(request.description);


        return this.productRepository.save(newProduct);
    }

    @Override
    public Product getProductById(UUID id) {
        return this.productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product Not Found"));
    }

    @Override
    public void deleteProductById(UUID id) {
        this.productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product to be deleted Not Found"));
        this.productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(UUID id, ProductDto request) {
        Product existingProduct=this.productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product Not Found"));
        Category category= this.categoryRepository.findById(request.categoryId).orElseThrow(()->new ResourceNotFoundException("Category not found"));
        existingProduct.setCategory(category);
        existingProduct.setName(request.name);
        existingProduct.setSku(request.sku);
        existingProduct.setPrice(request.price);
        existingProduct.setDescription(request.description);
        return this.productRepository.save(existingProduct);
    }

    @Override
    public List<Product> findAll() {

        System.out.println(this.productRepository.findAllWithCategory());
        return this.productRepository.findAllWithCategory();
//        return this.productRepository.findAll();
    }
}
