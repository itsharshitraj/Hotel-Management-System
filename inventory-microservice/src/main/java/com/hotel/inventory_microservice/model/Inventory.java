package com.hotel.inventory_microservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventoryId;

    @Column(nullable = false)
    @NotBlank(message = "Item name is mandatory")
    private String inventoryName;  // item name

    @Column(nullable = false)
    private String inventoryDepartment; // item categeory

    @Column(nullable = false)
    private int inventoryQuantity; // item quantity
}
