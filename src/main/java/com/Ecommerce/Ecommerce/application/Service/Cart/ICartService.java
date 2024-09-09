package com.Ecommerce.Ecommerce.application.Service.Cart;



import com.Ecommerce.Ecommerce.application.dto.cart.*;
import com.Ecommerce.Ecommerce.domain.model.Cart.Cart;

import java.util.List;
import java.util.UUID;

public interface ICartService {
    Cart createCart(UUID userId);
    Cart getCartByUserId(UUID userId);
    Cart getCartById(UUID id);
    Cart addItemToCart(UUID id, AddToCartDto request);
    Cart updateCart(UUID cartId, UpdateCartDto request);
    Cart updateItemInCart(UUID id,UUID cartItemId, UpdateCartItemDto request);
    void deleteCart(UUID id);
    Cart emptyCart(UUID id);
    Cart removeItemFromCart(UUID id,UUID cartItemId);
}
