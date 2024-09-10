package com.Ecommerce.Ecommerce.application.controller;

import com.Ecommerce.Ecommerce.application.Service.Cart.CartService;
import com.Ecommerce.Ecommerce.application.documentation.schema.CoreApiResponse;
import com.Ecommerce.Ecommerce.application.documentation.schema.cart.CartResponseSchema;
import com.Ecommerce.Ecommerce.application.documentation.schema.order.OrderResponseSchema;
import com.Ecommerce.Ecommerce.application.dto.cart.AddToCartDto;
import com.Ecommerce.Ecommerce.application.dto.cart.RemoveCartItemDto;
import com.Ecommerce.Ecommerce.application.dto.cart.UpdateCartDto;
import com.Ecommerce.Ecommerce.application.dto.cart.UpdateCartItemDto;

import com.Ecommerce.Ecommerce.domain.model.Cart.Cart;
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
@RequestMapping("cart")
@Tag(name = "Cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @Operation(summary = "Create cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CartResponseSchema.class))),

    })
    @PostMapping("/create")
    public ResponseEntity<CoreApiResponse<Cart>> createCart(@RequestParam String userId){
        return ResponseEntity.ok(CoreApiResponse.success("Cart Created Successfully",200,this.cartService.createCart(UUID.fromString(userId))));
    }

    @Operation(summary = "Get cart of a user by user id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CartResponseSchema.class))),

    })
    @GetMapping("/getByUserId")
    public ResponseEntity<CoreApiResponse<Cart>> getCartByUserId(@RequestParam String userId){
        return ResponseEntity.ok(CoreApiResponse.success("Success",200,this.cartService.getCartByUserId(UUID.fromString(userId))));
    }

    @Operation(summary = "Get cart by cart id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CartResponseSchema.class))),

    })
    @GetMapping("/getById")
    public ResponseEntity<CoreApiResponse<Cart>> getCartById(@RequestParam String id){
        return ResponseEntity.ok(CoreApiResponse.success("Success",200,this.cartService.getCartById(UUID.fromString(id))));
    }

    @Operation(summary = "Add an item to cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CartResponseSchema.class))),

    })
    @PostMapping("/addItemToCart")
    public ResponseEntity<CoreApiResponse<Cart>> addItemToCart(@RequestParam String id,@RequestBody AddToCartDto request){
        return ResponseEntity.ok(CoreApiResponse.success("Cart Created Successfully",200,this.cartService.addItemToCart(UUID.fromString(id),request)));
    }


    @Operation(summary = "Update an existing cart-item in a cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CartResponseSchema.class))),

    })
    @PutMapping("/updateItemInCart")
    public ResponseEntity<CoreApiResponse<Cart>> updateItemInCart(@RequestParam String id,@RequestParam String cartItemId, @RequestBody UpdateCartItemDto request){
        return ResponseEntity.ok(CoreApiResponse.success("Updated Successfully",200,this.cartService.updateItemInCart(UUID.fromString(id),UUID.fromString(cartItemId),request)));
    }

    @Operation(summary = "Empty cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CartResponseSchema.class))),

    })
    @PutMapping("/emptyCart")
    public ResponseEntity<CoreApiResponse<Cart>> emptyCart(@RequestParam String id){
        return ResponseEntity.ok(CoreApiResponse.success("Updated Successfully",200,this.cartService.emptyCart(UUID.fromString(id))));
    }

    @Operation(summary = "Delete order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json")),

    })
    @DeleteMapping("/deleteCart")
    public ResponseEntity<CoreApiResponse<?>> deleteCart(@RequestParam String id){
        this.cartService.deleteCart(UUID.fromString(id));

        return ResponseEntity.ok(CoreApiResponse.success("Cart Deleted Successfully",200));
    }

    @Operation(summary = "Remove an item from cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CartResponseSchema.class))),

    })
    @PutMapping("/removeItemFromCart")
    public ResponseEntity<CoreApiResponse<Cart>> removeItemFromCart(@RequestParam String id,@RequestParam String cartItemId){
        return ResponseEntity.ok(CoreApiResponse.success("Updated Successfully",200,this.cartService.removeItemFromCart(UUID.fromString(id),UUID.fromString(cartItemId))));
    }
}
