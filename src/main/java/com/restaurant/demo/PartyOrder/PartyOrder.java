package com.restaurant.demo.PartyOrder;

import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author cristian
 */
@AllArgsConstructor
@Entity
@Table(name= "party_order")
@NoArgsConstructor
@Getter
@Setter
public class PartyOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private int item_id;
    
    private String item_name;
    
    private long party_id;
    
    private String party_name;
    
    @Enumerated(EnumType.STRING)
    private PartyOrderStatus item_status;
    
    private int item_quantity;
    
    private double item_total;
}
