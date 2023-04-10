package com.restaurant.demo.Menu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Updated: 04/01/2023
 * @author cristian
 */
@Service
public class MenuService {
    
    @Autowired
    private MenuRepository repo;
    
    public List<Menu> getAllMenuItems(){
        return repo.findAll();
    }
    
    public Menu getMenuItem(long menuItemId){
        return repo.getReferenceById(menuItemId);
    }
    
    public void deleteMenuItem(long menuItemId){
        repo.deleteById(menuItemId);
    }
    
    public void saveMenuItems(Menu menu){
        repo.save(menu);
    }
}
