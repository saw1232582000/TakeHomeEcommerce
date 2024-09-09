package com.Ecommerce.Ecommerce.application.dto.order;

import com.Ecommerce.Ecommerce.domain.model.Order.OrderStatus;
import com.Ecommerce.Ecommerce.domain.model.Order.PaymentMethod;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

public class OrderDto {
    public OrderStatus status;


    @Enumerated(EnumType.STRING)
    public PaymentMethod payment_method;


    public String billing_name;


    public String billing_address;


    public String billing_email;


    public String billing_phone;


    public Double tax_amount;


    public Double shipping_cost;


    public Double discount;


    public Double total_price;


    public UUID userId;


    public List<OrderItemDto> order_items ;
}
