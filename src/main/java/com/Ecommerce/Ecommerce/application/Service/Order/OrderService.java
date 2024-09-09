package com.Ecommerce.Ecommerce.application.Service.Order;

import com.Ecommerce.Ecommerce.application.dto.order.OrderDto;
import com.Ecommerce.Ecommerce.application.dto.order.UpdateOrderDto;
import com.Ecommerce.Ecommerce.application.exception.ResourceNotFoundException;
import com.Ecommerce.Ecommerce.domain.model.Order.Orders;
import com.Ecommerce.Ecommerce.domain.model.OrderItem.OrderItem;
import com.Ecommerce.Ecommerce.domain.model.Product.Product;
import com.Ecommerce.Ecommerce.domain.model.User.User;
import com.Ecommerce.Ecommerce.domain.repository.Order.OrderItemRepository;
import com.Ecommerce.Ecommerce.domain.repository.Order.OrderRepository;
import com.Ecommerce.Ecommerce.domain.repository.Product.ProductRepository;
import com.Ecommerce.Ecommerce.domain.repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service

public class OrderService implements IOrderService{
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Orders createOrder(OrderDto request) {
        Orders newOrder=new Orders();
        newOrder.setOrdered_date(LocalDateTime.now());
        newOrder.setStatus(request.status);
        newOrder.setPayment_method(request.payment_method);
        newOrder.setBilling_name(request.billing_name);
        newOrder.setBilling_address(request.billing_address);
        newOrder.setBilling_email(request.billing_email);
        newOrder.setBilling_phone(request.billing_phone);
        newOrder.setTax_amount(request.tax_amount);
        newOrder.setShipping_cost(request.shipping_cost);
        newOrder.setShipping_cost(request.shipping_cost);
        newOrder.setDiscount(request.discount);
        newOrder.setTotal_price(request.total_price);
        User user= this.userRepository.findById(request.userId).orElseThrow(()->new ResourceNotFoundException("User not found"));
        newOrder.setUser(user);
        newOrder.setTax_amount(request.tax_amount);
       //Orders savedOrder = this.orderRepository.save(newOrder);

        List<OrderItem> newOrderItems=new ArrayList<>();
        request.order_items.forEach(item -> {
            OrderItem currentOrderItem=new OrderItem();
            currentOrderItem.setQuantity(item.quantity);
            currentOrderItem.setSold_price(item.sold_price);
            Product product=this.productRepository.findById(item.product_id).orElseThrow(()->new ResourceNotFoundException("product not found"));
            currentOrderItem.setProduct(product);
            currentOrderItem.setOrder(newOrder);
            newOrderItems.add(currentOrderItem);
        });
        newOrder.setOrder_items(newOrderItems);
        return this.orderRepository.save(newOrder);
    }

    @Override
    public Orders getOrderById(UUID id) {
        return this.orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order Not Found"));
    }

    @Override
    public void deleteOrderById(UUID id) {
        this.orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order to be deleted Not Found"));
        this.orderRepository.deleteById(id);
    }

    @Override
    public Orders updateOrder(UUID id, UpdateOrderDto request) {
        Orders existingOrder=this.orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order Not Found"));
        existingOrder.setStatus(request.status);
        return this.orderRepository.save(existingOrder);
    }

    @Override
    public List<Orders> findByUserId(UUID userId) {
        return this.orderRepository.findByUserId(userId);
    }
}
