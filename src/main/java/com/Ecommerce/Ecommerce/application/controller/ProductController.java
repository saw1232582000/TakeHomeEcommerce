package com.Ecommerce.Ecommerce.application.controller;


import com.Ecommerce.Ecommerce.application.Service.Product.ProductService;
import com.Ecommerce.Ecommerce.application.documentation.schema.CoreApiResponse;

import com.Ecommerce.Ecommerce.application.dto.product.ProductDto;
import com.Ecommerce.Ecommerce.domain.model.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<CoreApiResponse<Product>> createProduct(@RequestBody ProductDto request){
        return ResponseEntity.ok(CoreApiResponse.success("Product Created Successfully",200,this.productService.createProduct(request)));
    }

    @GetMapping("/getById")
    public ResponseEntity<CoreApiResponse<Product>> getProductById(@RequestParam String id){
        return ResponseEntity.ok(CoreApiResponse.success("Success",200,this.productService.getProductById(UUID.fromString(id))));
    }

    @GetMapping("/getAll")
    public ResponseEntity<CoreApiResponse<List<Product>>> getAll(){
        return ResponseEntity.ok(CoreApiResponse.success("success",200,this.productService.findAll()));
    }

    @PutMapping("/update")
    public ResponseEntity<CoreApiResponse<Product>> updateProduct(@RequestParam String id, @RequestBody ProductDto request){
        return ResponseEntity.ok(CoreApiResponse.success("Updated Successfully",200,this.productService.updateProduct(UUID.fromString(id),request)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CoreApiResponse<?>> deleteProduct(@RequestParam String id){
        this.productService.deleteProductById(UUID.fromString(id));

        return ResponseEntity.ok(CoreApiResponse.success("Product Deleted Successfully",200));
    }
}
