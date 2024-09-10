package com.Ecommerce.Ecommerce.application.documentation.schema.category;

import com.Ecommerce.Ecommerce.application.documentation.schema.product.ProductSchema;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Schema(name = "Category", description = "Details about the Category")
public class CategorySchema {

    @Schema(description = "The unique ID of the category",example = "string")
    private UUID id;

    @Schema(description = "Name of the category",example = "string")
    private String name;

    @Schema(description = "Description of the category",example = "string")
    private String description;

//    @Schema(description = "Products under this category")
//    private List<ProductSchema> products;
}
