package com.Ecommerce.Ecommerce.application.controller;

import com.Ecommerce.Ecommerce.application.Service.Order.OrderService;
import com.Ecommerce.Ecommerce.application.documentation.schema.CoreApiResponse;

import com.Ecommerce.Ecommerce.application.dto.order.OrderDto;
import com.Ecommerce.Ecommerce.application.dto.order.UpdateOrderDto;
import com.Ecommerce.Ecommerce.domain.model.Order.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/create")
    public ResponseEntity<CoreApiResponse<Orders>> createOrder(@RequestBody OrderDto request){
        return ResponseEntity.ok(CoreApiResponse.success("Order Created Successfully",200,this.orderService.createOrder(request)));
    }

    @GetMapping("/getById")
    public ResponseEntity<CoreApiResponse<Orders>> getOrderById(@RequestParam String id){
        return ResponseEntity.ok(CoreApiResponse.success("Success",200,this.orderService.getOrderById(UUID.fromString(id))));
    }

    @GetMapping("/getAllOrdersByUserId")
    public ResponseEntity<CoreApiResponse<List<Orders>>> getAll(@RequestParam String userId){
        return ResponseEntity.ok(CoreApiResponse.success("success",200,this.orderService.findByUserId(UUID.fromString(userId))));
    }

    @PutMapping("/update")
    public ResponseEntity<CoreApiResponse<Orders>> updateOrder(@RequestParam String id, @RequestBody UpdateOrderDto request){
        return ResponseEntity.ok(CoreApiResponse.success("Updated Successfully",200,this.orderService.updateOrder(UUID.fromString(id),request)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CoreApiResponse<?>> deleteOrder(@RequestParam String id){
        this.orderService.deleteOrderById(UUID.fromString(id));

        return ResponseEntity.ok(CoreApiResponse.success("Order Deleted Successfully",200));
    }
}
