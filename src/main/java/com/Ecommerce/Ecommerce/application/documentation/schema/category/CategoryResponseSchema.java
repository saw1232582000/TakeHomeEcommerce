package com.Ecommerce.Ecommerce.application.documentation.schema.category;

import com.Ecommerce.Ecommerce.application.documentation.schema.CoreApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "CategoryResponseSchema")
public class CategoryResponseSchema extends CoreApiResponse<CategorySchema> {
}
