package com.Ecommerce.Ecommerce.application.controller;

import com.Ecommerce.Ecommerce.application.Service.Cart.CartService;
import com.Ecommerce.Ecommerce.application.documentation.schema.CoreApiResponse;
import com.Ecommerce.Ecommerce.application.dto.cart.AddToCartDto;
import com.Ecommerce.Ecommerce.application.dto.cart.RemoveCartItemDto;
import com.Ecommerce.Ecommerce.application.dto.cart.UpdateCartDto;
import com.Ecommerce.Ecommerce.application.dto.cart.UpdateCartItemDto;

import com.Ecommerce.Ecommerce.domain.model.Cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/create")
    public ResponseEntity<CoreApiResponse<Cart>> createCart(@RequestParam String userId){
        return ResponseEntity.ok(CoreApiResponse.success("Cart Created Successfully",200,this.cartService.createCart(UUID.fromString(userId))));
    }

    @GetMapping("/getByUserId")
    public ResponseEntity<CoreApiResponse<Cart>> getCartByUserId(@RequestParam String userId){
        return ResponseEntity.ok(CoreApiResponse.success("Success",200,this.cartService.getCartByUserId(UUID.fromString(userId))));
    }

    @GetMapping("/getById")
    public ResponseEntity<CoreApiResponse<Cart>> getCartById(@RequestParam String id){
        return ResponseEntity.ok(CoreApiResponse.success("Success",200,this.cartService.getCartById(UUID.fromString(id))));
    }

    @PostMapping("/addItemToCart")
    public ResponseEntity<CoreApiResponse<Cart>> addItemToCart(@RequestParam String id,@RequestBody AddToCartDto request){
        return ResponseEntity.ok(CoreApiResponse.success("Cart Created Successfully",200,this.cartService.addItemToCart(UUID.fromString(id),request)));
    }

//    @PutMapping("/updateCart")
//    public ResponseEntity<CoreApiResponse<Cart>> updateCart(@RequestParam String id, @RequestBody UpdateCartDto request){
//        return ResponseEntity.ok(CoreApiResponse.success("Updated Successfully",200,this.cartService.updateCart(UUID.fromString(id),request)));
//    }
    @PutMapping("/updateItemInCart")
    public ResponseEntity<CoreApiResponse<Cart>> updateItemInCart(@RequestParam String id,@RequestParam String cartItemId, @RequestBody UpdateCartItemDto request){
        return ResponseEntity.ok(CoreApiResponse.success("Updated Successfully",200,this.cartService.updateItemInCart(UUID.fromString(id),UUID.fromString(cartItemId),request)));
    }

    @PutMapping("/emptyCart")
    public ResponseEntity<CoreApiResponse<Cart>> emptyCart(@RequestParam String id){
        return ResponseEntity.ok(CoreApiResponse.success("Updated Successfully",200,this.cartService.emptyCart(UUID.fromString(id))));
    }

    @DeleteMapping("/deleteCart")
    public ResponseEntity<CoreApiResponse<?>> deleteCart(@RequestParam String id){
        this.cartService.deleteCart(UUID.fromString(id));

        return ResponseEntity.ok(CoreApiResponse.success("Cart Deleted Successfully",200));
    }

    @PutMapping("/removeItemFromCart")
    public ResponseEntity<CoreApiResponse<Cart>> removeItemFromCart(@RequestParam String id,@RequestParam String cartItemId){
        return ResponseEntity.ok(CoreApiResponse.success("Updated Successfully",200,this.cartService.removeItemFromCart(UUID.fromString(id),UUID.fromString(cartItemId))));
    }
}
