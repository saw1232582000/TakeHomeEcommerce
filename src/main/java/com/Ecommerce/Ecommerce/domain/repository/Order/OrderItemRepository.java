package com.Ecommerce.Ecommerce.domain.repository.Order;

import com.Ecommerce.Ecommerce.domain.model.OrderItem.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
}
