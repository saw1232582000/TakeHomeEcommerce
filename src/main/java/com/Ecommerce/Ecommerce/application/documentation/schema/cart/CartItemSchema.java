package com.Ecommerce.Ecommerce.application.documentation.schema.cart;

import com.Ecommerce.Ecommerce.application.documentation.schema.product.ProductSchema;
import com.Ecommerce.Ecommerce.domain.model.Product.Product;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

public class CartItemSchema {
    public UUID id;


    public Integer quantity;


    public ProductSchema product;
}
