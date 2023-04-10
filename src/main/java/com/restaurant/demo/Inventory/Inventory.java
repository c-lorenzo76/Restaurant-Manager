package com.restaurant.demo.Inventory;

import jakarta.persistence.*;
import lombok.*;
/**
 * Updated: 04/01/2023
 * @author cristian
 */

@AllArgsConstructor
@Entity
@Table(name = "inventory")
@NoArgsConstructor
@Getter
@Setter
public class Inventory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String itemName;
    private Integer quantity;
    
    
    
}
