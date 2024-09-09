package com.Ecommerce.Ecommerce.domain.repository.Order;


import com.Ecommerce.Ecommerce.domain.model.Order.Orders;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IBaseOrderRepository  {
    //@Query("SELECT DISTINCT o FROM Orders o JOIN FETCH o.order_items oi WHERE o.user.id = :userId")
//    @EntityGraph(attributePaths = {"order_items"})
    List<Orders> findByUserId(UUID userId);
}
