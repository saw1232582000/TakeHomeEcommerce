package com.Ecommerce.Ecommerce.application.dto.order;

import com.Ecommerce.Ecommerce.domain.model.Order.OrderStatus;
import com.Ecommerce.Ecommerce.domain.model.Order.PaymentMethod;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UpdateOrderDto {
    public OrderStatus status;

    public PaymentMethod payment_method;

    public String billing_name;

    public String billing_address;

    public String billing_email;

    public String billing_phone;
}
