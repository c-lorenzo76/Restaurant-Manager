package com.restaurant.demo.InventoryRestock;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Updated: 03/31/2023
 * @author cristian
 */
public interface InventoryRestockRepository extends JpaRepository<InventoryRestock, Long> {
    
}
