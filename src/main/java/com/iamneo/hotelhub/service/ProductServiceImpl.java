package com.iamneo.hotelhub.service;

import com.iamneo.hotelhub.dto.ProductRequest;
import com.iamneo.hotelhub.model.Product;
import com.iamneo.hotelhub.repo.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setDepartment(productRequest.getDepartment());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.orElse(null);
    }

    @Override
    public Product updateProduct(Long productId, ProductRequest productRequest) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            existingProduct.setDepartment(productRequest.getDepartment());
            existingProduct.setName(productRequest.getName());
            existingProduct.setPrice(productRequest.getPrice());
            existingProduct.setStock(productRequest.getStock());
            return productRepository.save(existingProduct);
        }
        throw new EntityNotFoundException("Product not found with id: " + productId);
    }


    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
