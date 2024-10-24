package com.multishop.fusiontech.services;

import com.multishop.fusiontech.dtos.product.*;
import com.multishop.fusiontech.payloads.PaginationPayload;

import java.util.List;

public interface ProductService {

    ProductDetailDto getProductDetail(Long id);

    ProductUpdateDto getUpdatedProduct(Long id);

    List<ProductFeaturedDto> getFeaturedProducts();

    List<ProductRelatedDto> getRelatedProducts(Long categoryId, Long productId);

    List<ProductOfferedDto> getOfferedProducts();

    List<ProductShopDto> getShopProducts();

    PaginationPayload<ProductAdminDto> getAdminProducts(Integer pageNumber);

    List<ProductShopDto> getFilteredProducts(int price, int category, int brand);

    List<ProductShopDto> getCatalogProducts(Long categoryId, Long subcategoryId);

    List<ProductShopDto> getSearchProducts(String keyword);

    void updateProductRating(Long productId);

    boolean createProduct(ProductCreateDto productCreateDto);

    boolean updateProduct(Long id, ProductUpdateDto productUpdateDto);

    void deleteProduct(Long id);
}
