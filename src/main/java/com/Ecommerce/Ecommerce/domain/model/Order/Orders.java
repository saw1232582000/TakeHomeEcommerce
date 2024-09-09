package com.Ecommerce.Ecommerce.domain.model.Order;

import com.Ecommerce.Ecommerce.domain.model.OrderItem.OrderItem;
import com.Ecommerce.Ecommerce.domain.model.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")

public class Orders {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getOrdered_date() {
        return ordered_date;
    }

    public void setOrdered_date(LocalDateTime ordered_date) {
        this.ordered_date = ordered_date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }



    public String getBilling_name() {
        return billing_name;
    }

    public void setBilling_name(String billing_name) {
        this.billing_name = billing_name;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }

    public String getBilling_email() {
        return billing_email;
    }

    public void setBilling_email(String billing_email) {
        this.billing_email = billing_email;
    }

    public String getBilling_phone() {
        return billing_phone;
    }

    public void setBilling_phone(String billing_phone) {
        this.billing_phone = billing_phone;
    }

    public Double getTax_amount() {
        return tax_amount;
    }

    public void setTax_amount(Double tax_amount) {
        this.tax_amount = tax_amount;
    }

    public Double getShipping_cost() {
        return shipping_cost;
    }

    public void setShipping_cost(Double shipping_cost) {
        this.shipping_cost = shipping_cost;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrder_items() {
        return order_items;
    }

    public void setOrder_items(List<OrderItem> order_items) {
        this.order_items = order_items;
    }

    @Column(name = "ordered_date", nullable = true, updatable = false)
    private LocalDateTime ordered_date;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name="payment_method")
    @Enumerated(EnumType.STRING)
    private PaymentMethod payment_method;

    @Column(name="billing_name")
    private String billing_name;

    @Column(name="billing_address")
    private String billing_address;

    @Column(name="billing_email")
    private String billing_email;

    @Column(name="billing_phone")
    private String billing_phone;

    @Column(name="tax_amount")
    private Double tax_amount;

    @Column(name="shipping_cost")
    private Double shipping_cost;

    @Column(name="discount")
    private Double discount;

    public PaymentMethod getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(PaymentMethod payment_method) {
        this.payment_method = payment_method;
    }

    @Column(name="total_price")
    private Double total_price;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
//    @JsonIgnore
    private List<OrderItem> order_items= new ArrayList<>();
}
