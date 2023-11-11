package com.iamneo.hotelhub.controller;
import com.iamneo.hotelhub.dto.ProductRequest;
import com.iamneo.hotelhub.model.Product;
import com.iamneo.hotelhub.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add-product")
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest productRequest) {
        Product addedProduct = productService.addProduct(productRequest);
        return ResponseEntity.ok(addedProduct);
    }

    @GetMapping("/all-products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }


    @PutMapping("/update-product/{productId}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long productId,
            @RequestBody ProductRequest productRequest,
            @RequestHeader HttpHeaders headers) {
        // Log headers for debugging
        System.out.println("Headers: " + headers);

        // Log other details for debugging
        System.out.println("Updating product with ID: " + productId);

        try {
            Product updatedProduct = productService.updateProduct(productId, productRequest);
            return ResponseEntity.ok(updatedProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete-product/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
