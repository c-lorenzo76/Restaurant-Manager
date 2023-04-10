package com.restaurant.demo.Controller;

import com.restaurant.demo.Menu.Menu;
import org.springframework.ui.Model;
import com.restaurant.demo.Menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author cristian
 */


@Controller
@RequestMapping("/manager")
public class ManagerController {
    
    @Autowired
    MenuService menuService;
    
    @GetMapping("")
    public String viewManagerHome(){
        return "manager/managerHome";
    }
    
    
   @GetMapping("/menu")
   public String viewMenuManager(Model model){
       model.addAttribute("menuList", menuService.getAllMenuItems());
       return "manager/managerViewMenu";
   }
   
   @GetMapping("/new-item")
   public String newItem(Model model){
       return  "manager/managerNewItem";
   }
   
   @GetMapping("/create")
   public String createItem(Menu item){
       menuService.saveMenuItems(item);
        return "redirect:/manager/menu";
   }
   
   


    
    
}
