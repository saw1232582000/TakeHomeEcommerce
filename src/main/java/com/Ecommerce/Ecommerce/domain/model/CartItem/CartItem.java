package com.Ecommerce.Ecommerce.domain.model.CartItem;

import com.Ecommerce.Ecommerce.domain.model.Cart.Cart;
import com.Ecommerce.Ecommerce.domain.model.Order.Orders;
import com.Ecommerce.Ecommerce.domain.model.OrderItem.OrderItem;
import com.Ecommerce.Ecommerce.domain.model.Product.Product;
import com.Ecommerce.Ecommerce.domain.model.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;


import java.util.UUID;

@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name="quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }


}
