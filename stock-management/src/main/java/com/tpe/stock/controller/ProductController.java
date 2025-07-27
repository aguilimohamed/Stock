package com.tpe.stock.controller;

import com.tpe.stock.entity.Product;
import com.tpe.stock.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // POST /api/products
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    // PATCH /api/products/{code}/stock?quantity=10
    @PatchMapping("/{productCode}/stock")
    public ResponseEntity<Product> updateStock(
            @PathVariable String productCode,
            @RequestParam int quantity) {
        return ResponseEntity.ok(productService.updateStock(productCode, quantity));
    }

    // GET /api/products/hello
    @GetMapping("/hello")
    public String hello() {
        return "API Products Working!";
    }
}
