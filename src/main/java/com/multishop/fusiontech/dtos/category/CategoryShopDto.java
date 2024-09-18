package com.multishop.fusiontech.dtos.category;

import com.multishop.fusiontech.models.Product;
import com.multishop.fusiontech.models.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryShopDto {
    private Long id;
    private String name;
    private Integer productQuantity;
    private List<Subcategory> subcategories;
    private List<Product> products;
}
