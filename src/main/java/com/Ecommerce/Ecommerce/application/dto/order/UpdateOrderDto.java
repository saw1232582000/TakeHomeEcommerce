package com.Ecommerce.Ecommerce.application.dto.order;

import com.Ecommerce.Ecommerce.domain.model.Order.OrderStatus;
import lombok.Data;

@Data
public class UpdateOrderDto {
    public OrderStatus status;
}
