package com.Ecommerce.Ecommerce.application.Service.Order;


import com.Ecommerce.Ecommerce.application.dto.order.OrderDto;
import com.Ecommerce.Ecommerce.application.dto.order.UpdateOrderDto;
import com.Ecommerce.Ecommerce.domain.model.Order.Orders;

import java.util.List;
import java.util.UUID;

public interface IOrderService {
    Orders createOrder(OrderDto request);
    Orders getOrderById(UUID id);
    void deleteOrderById(UUID id);
    Orders updateOrder(UUID id, UpdateOrderDto request);
    List<Orders> findByUserId(UUID userId);
}
