package com.Ecommerce.Ecommerce.application.Service.Cart;

import com.Ecommerce.Ecommerce.application.dto.cart.*;
import com.Ecommerce.Ecommerce.application.exception.ResourceNotFoundException;
import com.Ecommerce.Ecommerce.domain.model.Cart.Cart;
import com.Ecommerce.Ecommerce.domain.model.CartItem.CartItem;
import com.Ecommerce.Ecommerce.domain.model.User.User;
import com.Ecommerce.Ecommerce.domain.repository.Cart.CartRepository;
import com.Ecommerce.Ecommerce.domain.repository.Product.ProductRepository;
import com.Ecommerce.Ecommerce.domain.repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CartService implements ICartService{

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }


    @Override
    public Cart createCart(UUID userId) {
        Cart newCart=new Cart();
        newCart.setCreated_date(LocalDateTime.now());
        User user =  userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found "));
        newCart.setUser(user);
        return this.cartRepository.save(newCart);
    }

    @Override
    public Cart getCartByUserId(UUID userId) {
        return this.cartRepository.findByUserId(userId).orElseThrow(()->new ResourceNotFoundException("Cart Not Found"));
    }

    @Override
    public Cart getCartById(UUID id) {
        return this.cartRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Cart not found"));
    }

    @Override
    public Cart addItemToCart(UUID id, AddToCartDto request) {
        Cart cart=this.cartRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Cart not found"));

        CartItem newCartItem=new CartItem();
        newCartItem.setQuantity(request.quantity);
        newCartItem.setProduct(this.productRepository.findById(request.productId).orElseThrow(()->new ResourceNotFoundException("Product Not Found")));
        newCartItem.setCart(cart);
        cart.getCart_items().add(newCartItem);

        return this.cartRepository.save(cart);

    }

    @Override
    public Cart updateCart(UUID cartId, UpdateCartDto request) {
        return null;
    }

    @Override
    public Cart updateItemInCart(UUID id,UUID cartItemId, UpdateCartItemDto request) {
        Cart cart=this.cartRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Cart not found"));
        cart.getCart_items().forEach(item->{
            if(item.getId().equals(cartItemId) ){
                item.setQuantity(request.quantity);

            }
        });
        return this.cartRepository.save(cart);
    }

    @Override
    public void deleteCart(UUID id) {
        Cart cart=this.cartRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Cart not found"));
        this.cartRepository.delete(cart);
    }

    @Override
    public Cart emptyCart(UUID id) {
        Cart cart=this.cartRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Cart not found"));
        cart.getCart_items().removeAll(cart.getCart_items());
        return this.cartRepository.save(cart);
    }

    @Override
    public Cart removeItemFromCart(UUID id,UUID cartItemId) {
        Cart cart=this.cartRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Cart not found"));
        CartItem itemToRemove = cart.getCart_items().stream()
                .filter(item -> item.getId().equals(cartItemId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("CartItem not found"));

        cart.getCart_items().remove(itemToRemove);
        return this.cartRepository.save(cart);
    }
}
