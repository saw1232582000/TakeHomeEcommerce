package com.Ecommerce.Ecommerce.application.controller;

import com.Ecommerce.Ecommerce.application.Service.Order.OrderService;
import com.Ecommerce.Ecommerce.application.documentation.schema.CoreApiResponse;

import com.Ecommerce.Ecommerce.application.documentation.schema.order.OrderListResponseSchema;
import com.Ecommerce.Ecommerce.application.documentation.schema.order.OrderResponseSchema;
import com.Ecommerce.Ecommerce.application.documentation.schema.product.ProductResponseSchema;
import com.Ecommerce.Ecommerce.application.dto.order.OrderDto;
import com.Ecommerce.Ecommerce.application.dto.order.UpdateOrderDto;
import com.Ecommerce.Ecommerce.domain.model.Order.Orders;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("order")
@Tag(name = "Order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Create new order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderResponseSchema.class))),

    })
    @PostMapping("/create")
    public ResponseEntity<CoreApiResponse<Orders>> createOrder(@RequestBody OrderDto request){
        return ResponseEntity.ok(CoreApiResponse.success("Order Created Successfully",200,this.orderService.createOrder(request)));
    }

    @Operation(summary = "Get order detail by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderResponseSchema.class))),

    })
    @GetMapping("/getById")
    public ResponseEntity<CoreApiResponse<Orders>> getOrderById(@RequestParam String id){
        return ResponseEntity.ok(CoreApiResponse.success("Success",200,this.orderService.getOrderById(UUID.fromString(id))));
    }

    @Operation(summary = "Get a list of all orders of a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderListResponseSchema.class))),

    })
    @GetMapping("/getAllOrdersByUserId")
    public ResponseEntity<CoreApiResponse<List<Orders>>> getAll(@RequestParam String userId){
        return ResponseEntity.ok(CoreApiResponse.success("success",200,this.orderService.findByUserId(UUID.fromString(userId))));
    }

    @Operation(summary = "Update order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderResponseSchema.class))),

    })
    @PutMapping("/update")
    public ResponseEntity<CoreApiResponse<Orders>> updateOrder(@RequestParam String id, @RequestBody UpdateOrderDto request){
        return ResponseEntity.ok(CoreApiResponse.success("Updated Successfully",200,this.orderService.updateOrder(UUID.fromString(id),request)));
    }

    @Operation(summary = "Delete an order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json")),

    })
    @DeleteMapping("/delete")
    public ResponseEntity<CoreApiResponse<?>> deleteOrder(@RequestParam String id){
        this.orderService.deleteOrderById(UUID.fromString(id));

        return ResponseEntity.ok(CoreApiResponse.success("Order Deleted Successfully",200));
    }
}
