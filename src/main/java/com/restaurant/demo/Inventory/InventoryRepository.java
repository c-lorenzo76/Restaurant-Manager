/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.restaurant.demo.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cristian
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long>{
    
}
