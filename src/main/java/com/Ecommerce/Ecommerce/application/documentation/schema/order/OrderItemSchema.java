package com.Ecommerce.Ecommerce.application.documentation.schema.order;

import com.Ecommerce.Ecommerce.application.documentation.schema.product.ProductSchema;
import lombok.Data;


import java.util.UUID;

@Data
public class OrderItemSchema {
    public UUID id;


    public Double sold_price;


    public Integer quantity;


    public ProductSchema product;
}
