package com.tpe.stock.service;

import com.tpe.stock.entity.Product;
import com.tpe.stock.entity.StockMovement;
import com.tpe.stock.repository.StockMovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StockMovementService {
    private final StockMovementRepository movementRepository;
    private final ProductService productService;

    public StockMovement recordMovement(StockMovement movement) {
        Product product = movement.getProduct();
        if (product == null || product.getProductCode() == null) {
            throw new IllegalArgumentException("Product must be specified");
        }

        productService.updateStock(product.getProductCode(), movement.getQuantity());
        return movementRepository.save(movement);
    }
}
