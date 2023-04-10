package com.restaurant.demo.Menu;

import jakarta.persistence.*;
import lombok.*;
/**
 * Updated: 04/01/2023
 * @author cristian
 */
@AllArgsConstructor
@Entity
@Table(name = "menu")
@NoArgsConstructor
@Getter
@Setter
public class Menu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    
    private String itemName;
   
    private String type;
   
    private double price;
}
