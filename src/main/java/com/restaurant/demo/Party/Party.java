package com.restaurant.demo.Party;

import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author cristian
 */
@AllArgsConstructor
@Entity
@Table(name = "party")
@NoArgsConstructor
@Getter
@Setter
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String party_name;
    
    @Enumerated(EnumType.STRING)
    private PartyStatus party_status;
    
    
}
