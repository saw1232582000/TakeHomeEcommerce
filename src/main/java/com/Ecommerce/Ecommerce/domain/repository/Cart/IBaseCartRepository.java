package com.Ecommerce.Ecommerce.domain.repository.Cart;

import com.Ecommerce.Ecommerce.domain.model.Cart.Cart;

import java.util.Optional;
import java.util.UUID;

public interface IBaseCartRepository {
    Optional<Cart> findByUserId(UUID userId);
}
