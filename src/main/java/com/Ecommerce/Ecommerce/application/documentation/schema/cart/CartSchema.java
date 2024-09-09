package com.Ecommerce.Ecommerce.application.documentation.schema.cart;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CartSchema {
    public UUID id;

    public LocalDateTime created_date;

    public List<CartItemSchema> cart_items;
}
