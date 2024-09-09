package com.Ecommerce.Ecommerce.domain.model.Cart;

import com.Ecommerce.Ecommerce.domain.model.CartItem.CartItem;

import com.Ecommerce.Ecommerce.domain.model.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private LocalDateTime created_date;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cart_items= new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCart_items() {
        return cart_items;
    }

    public void setCart_items(List<CartItem> cart_items) {
        this.cart_items = cart_items;
    }


}
