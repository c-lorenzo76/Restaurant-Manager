package com.restaurant.demo.InventoryRestock;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Updated: 03/31/2023
 * @author cristian
 */
@Service
public class InventoryRestockService {
    
    @Autowired
    private InventoryRestockRepository repo;
    
    public List<InventoryRestock> getAllInventoryItems(){
        return repo.findAll();
    }
    
    public InventoryRestock getInventoryItem(Long inventoryItemID){
        return repo.getReferenceById(inventoryItemID);
    }
    
    public void deleteItem(long inventoryItemID){
        repo.deleteById(inventoryItemID);
    }
    
    void saveItem(InventoryRestock item){
        repo.save(item);
    }
    
}
