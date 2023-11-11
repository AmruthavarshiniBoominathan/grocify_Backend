package com.iamneo.hotelhub.service;

import com.iamneo.hotelhub.dto.ProductRequest;
import com.iamneo.hotelhub.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(ProductRequest productRequest);

    List<Product> getAllProducts();

    Product getProductById(Long productId);

    Product updateProduct(Long productId, ProductRequest productRequest);


    void deleteProduct(Long productId);
}
