package com.tpe.stock.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Enumerated(EnumType.STRING)  // Correction de "SYRING" à "STRING"
    private MovementType type;     // IN, OUT, ADJUSTMENT

    @CreationTimestamp
    private LocalDateTime movementDate;

    public enum MovementType {
        IN,         // Entrée de stock
        OUT,        // Sortie de stock
        ADJUSTMENT  // Ajustement de stock
    }
}