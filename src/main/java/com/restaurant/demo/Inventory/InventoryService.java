package com.restaurant.demo.Inventory;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Updated: 04/01/2023
 * @author cristian
 */
@Service
public class InventoryService {
    
    @Autowired
    private InventoryRepository repo;
    
    public List<Inventory> getAllItems(){
        return repo.findAll();
    }
    
    public Inventory getInventory(long item_id){
        return repo.getReferenceById(item_id);
    }
    
    public void deleteItem(long item_id){
        repo.deleteById(item_id);
    }
    
    void saveItem(Inventory item){
        repo.save(item);
    }
}
