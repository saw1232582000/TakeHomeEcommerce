package com.Ecommerce.Ecommerce.application.controller;

import com.Ecommerce.Ecommerce.application.Service.Category.CategoryService;
import com.Ecommerce.Ecommerce.application.documentation.schema.category.CategoryResponseSchema;
import com.Ecommerce.Ecommerce.application.documentation.schema.category.CategorySchema;
import com.Ecommerce.Ecommerce.application.dto.category.CategoryDto;
import com.Ecommerce.Ecommerce.application.documentation.schema.CoreApiResponse;
import com.Ecommerce.Ecommerce.domain.model.Category.Category;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("category")
@Tag(name = "Category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Operation(summary = "Create new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created category",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryResponseSchema.class))),

    })
    @PostMapping("/create")
    public ResponseEntity<CoreApiResponse<Category>> createCategory(@RequestBody CategoryDto request){
        return ResponseEntity.ok(CoreApiResponse.success("Category Created Successfully",200,this.categoryService.createCategory(request)));
    }

    @GetMapping("/getById")
    public ResponseEntity<CoreApiResponse<Category>> getCategoryById(@RequestParam String id){
        return ResponseEntity.ok(CoreApiResponse.success("Success",200,this.categoryService.getCategoryById(UUID.fromString(id))));
    }

    @GetMapping("/getAll")
    public ResponseEntity<CoreApiResponse<List<Category>>> getAll(){
        return ResponseEntity.ok(CoreApiResponse.success("success",200,this.categoryService.findAll()));
    }

    @PutMapping("/update")
    public ResponseEntity<CoreApiResponse<Category>> updateCategory(@RequestParam String id, @RequestBody CategoryDto request){
        return ResponseEntity.ok(CoreApiResponse.success("Updated Successfully",200,this.categoryService.updateCategory(UUID.fromString(id),request)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CoreApiResponse<?>> deleteCategory(@RequestParam String id){
        this.categoryService.deleteCategoryById(UUID.fromString(id));

        return ResponseEntity.ok(CoreApiResponse.success("Category Deleted Successfully",200));
    }


}
