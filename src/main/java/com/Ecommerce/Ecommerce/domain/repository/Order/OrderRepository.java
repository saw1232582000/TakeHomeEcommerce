package com.Ecommerce.Ecommerce.domain.repository.Order;

import com.Ecommerce.Ecommerce.domain.model.Order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Orders, UUID>,IBaseOrderRepository {
}
