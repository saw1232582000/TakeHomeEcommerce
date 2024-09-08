package com.Ecommerce.Ecommerce.application.dto.product;

import com.Ecommerce.Ecommerce.domain.model.Category.Category;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.UUID;


public class ProductDto {
    public UUID categoryId;


    public String name;


    public Double price;

    public String image;

    public String sku;


    public String description;



}
