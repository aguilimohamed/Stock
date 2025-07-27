package com.tpe.stock.service;

import com.tpe.stock.entity.Product;
import com.tpe.stock.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateStock(String productCode, int quantityChange) {
        Product product = productRepository.findByProductCode(productCode)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        product.setQuantityInStock(product.getQuantityInStock() + quantityChange);
        return productRepository.save(product);
    }


}