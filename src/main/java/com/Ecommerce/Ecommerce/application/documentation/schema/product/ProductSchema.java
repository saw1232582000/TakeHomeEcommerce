package com.Ecommerce.Ecommerce.application.documentation.schema.product;

import com.Ecommerce.Ecommerce.application.documentation.schema.category.CategorySchema;
import com.Ecommerce.Ecommerce.domain.model.Category.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.UUID;

@Data
@Schema(name= "Product", description = "Details about the product")
public class ProductSchema {
    private UUID id;

    @Schema(description = "Name of product")
    private String name;

    @Schema(description = "Price of product")
    private Double price;

    @Schema(description = "SKU of product")
    private String sku;

    @Schema(description = "Product Description")
    private String description;

    @Schema(description = "Product Category")
    private CategorySchema category;
}
