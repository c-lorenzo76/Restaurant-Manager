package com.restaurant.demo.InventoryRestock;

import jakarta.persistence.*;
import lombok.*;
/**
 * Updated: 03/31/2023
 * @author cristian
 */

@AllArgsConstructor
@Entity
@Table(name = "inventory_restock")
@NoArgsConstructor
@Getter
@Setter
public class InventoryRestock {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private long managerID;
    private long itemID;
    private String itemName;
    private Integer quantity;
     
}
