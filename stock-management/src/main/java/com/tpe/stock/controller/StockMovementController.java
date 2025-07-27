package com.tpe.stock.controller;


import com.tpe.stock.entity.StockMovement;
import com.tpe.stock.service.StockMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/movements")
@RequiredArgsConstructor
public class StockMovementController {
    private final StockMovementService movementService;

    @PostMapping
    public ResponseEntity<StockMovement> recordMovement(@RequestBody StockMovement movement) {
        return ResponseEntity.ok(movementService.recordMovement(movement));
    }
}
