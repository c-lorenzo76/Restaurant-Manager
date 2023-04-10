package com.restaurant.demo.Employee;

import jakarta.persistence.*;
import lombok.*;


/**
 * Updated: 03/31/2023
 * @author cristian
 */
@AllArgsConstructor
@Entity
@Table(name = "Employees")
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Title title;
    private double payrate; 
    
    public Employee(String username, String password, Title title, double payrate){
        this.username = username;
        this.password = password;
        this.title = title;
        this.payrate = payrate;
    }
    
    
}
