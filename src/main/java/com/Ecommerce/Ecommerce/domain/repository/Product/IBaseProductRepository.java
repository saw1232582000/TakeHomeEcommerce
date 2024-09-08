package com.Ecommerce.Ecommerce.domain.repository.Product;

import com.Ecommerce.Ecommerce.domain.model.Product.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBaseProductRepository {
    @EntityGraph(attributePaths = {"category"})
    @Query("SELECT p  FROM Product p LEFT JOIN  FETCH p.category")
    List<Product> findAllWithCategory();
}
