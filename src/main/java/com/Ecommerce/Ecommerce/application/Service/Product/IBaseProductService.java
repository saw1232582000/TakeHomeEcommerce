package com.Ecommerce.Ecommerce.application.Service.Product;


import com.Ecommerce.Ecommerce.application.dto.product.ProductDto;
import com.Ecommerce.Ecommerce.domain.model.Product.Product;

import java.util.List;
import java.util.UUID;

public interface IBaseProductService {
    Product createProduct(ProductDto request);
    Product getProductById(UUID id);
    void deleteProductById(UUID id);
    Product updateProduct(UUID id,ProductDto request);
    List<Product> findAll();
}
