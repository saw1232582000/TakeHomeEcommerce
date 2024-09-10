package com.Ecommerce.Ecommerce.application.controller;


import com.Ecommerce.Ecommerce.application.Service.Product.ProductService;
import com.Ecommerce.Ecommerce.application.documentation.schema.CoreApiResponse;

import com.Ecommerce.Ecommerce.application.documentation.schema.category.CategoryResponseSchema;
import com.Ecommerce.Ecommerce.application.documentation.schema.product.ProductListResponseSchema;
import com.Ecommerce.Ecommerce.application.documentation.schema.product.ProductResponseSchema;
import com.Ecommerce.Ecommerce.application.documentation.schema.product.ProductSchema;
import com.Ecommerce.Ecommerce.application.dto.product.ProductDto;
import com.Ecommerce.Ecommerce.domain.model.Product.Product;
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
@RequestMapping("product")
@Tag(name = "Product", description = "Admin only route")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Create new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponseSchema.class))),

    })
    @PostMapping("/create")
    public ResponseEntity<CoreApiResponse<Product>> createProduct(@RequestBody ProductDto request){
        return ResponseEntity.ok(CoreApiResponse.success("Product Created Successfully",200,this.productService.createProduct(request)));
    }

    @Operation(summary = "Get product By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponseSchema.class))),

    })
    @GetMapping("/getById")
    public ResponseEntity<CoreApiResponse<Product>> getProductById(@RequestParam String id){
        return ResponseEntity.ok(CoreApiResponse.success("Success",200,this.productService.getProductById(UUID.fromString(id))));
    }

    @Operation(summary = "Get list of all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductListResponseSchema.class))),

    })
    @GetMapping("/getAll")
    public ResponseEntity<CoreApiResponse<List<Product>>> getAll(){
        return ResponseEntity.ok(CoreApiResponse.success("success",200,this.productService.findAll()));
    }

    @Operation(summary = "Update a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponseSchema.class))),

    })
    @PutMapping("/update")
    public ResponseEntity<CoreApiResponse<Product>> updateProduct(@RequestParam String id, @RequestBody ProductDto request){
        return ResponseEntity.ok(CoreApiResponse.success("Updated Successfully",200,this.productService.updateProduct(UUID.fromString(id),request)));
    }

    @Operation(summary = "Delete a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json")),

    })
    @DeleteMapping("/delete")
    public ResponseEntity<CoreApiResponse<?>> deleteProduct(@RequestParam String id){
        this.productService.deleteProductById(UUID.fromString(id));

        return ResponseEntity.ok(CoreApiResponse.success("Product Deleted Successfully",200));
    }
}
