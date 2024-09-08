package com.Ecommerce.Ecommerce.domain.repository.Product;

import com.Ecommerce.Ecommerce.domain.model.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductCategory extends JpaRepository<Product, UUID>,IBaseProductRepository {
}
