package com.Ecommerce.Ecommerce.application.documentation.schema.order;

import com.Ecommerce.Ecommerce.domain.model.Order.OrderStatus;
import com.Ecommerce.Ecommerce.domain.model.Order.PaymentMethod;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class OrderSchema {
    public UUID id;
    public LocalDateTime ordered_date;
    public OrderStatus status;
    public PaymentMethod payment_method;
    public String  billing_name;
    public String  billing_address;
    public String  billing_email;
    public String  billing_phone;
    public Integer  tax_amount;
    public Integer  shipping_cost;
    public Integer  discount;
    public Integer  total_price;

    public List<OrderItemSchema> order_items;
}
