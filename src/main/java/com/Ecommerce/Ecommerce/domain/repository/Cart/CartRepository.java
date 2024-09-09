package com.Ecommerce.Ecommerce.domain.repository.Cart;

import com.Ecommerce.Ecommerce.domain.model.Cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID>,IBaseCartRepository {
}
