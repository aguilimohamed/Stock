package com.tpe.stock.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductRequest {
    @NotBlank(message = "Le code produit est obligatoire")
    private String productCode;

    @NotBlank(message = "Le nom est obligatoire")
    private String name;

    @Positive(message = "Le prix doit être positif")
    private Double price;

    @Min(value = 0, message = "Le stock ne peut pas être négatif")
    private Integer quantityInStock;

    // Optionnel : Ajoutez 'description' si nécessaire
    private String description;
}