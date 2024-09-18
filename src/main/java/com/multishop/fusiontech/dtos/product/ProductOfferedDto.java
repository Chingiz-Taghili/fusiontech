package com.multishop.fusiontech.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOfferedDto {
    private Long id;
    private String name;
    private String image;
    private double discountPercent;
    private Date discountDate;
}
