package com.restaurant.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author collins
 */

@Controller
@RequestMapping("/chef")
public class ChefController {
    
    @GetMapping("")
    public String viewChefHome(){
        return "chef/chefHome";
    }
    
    @GetMapping("/new-order")
    public String newOrder(Model model){
        return "chef/chefNewOrder";
    }
    
    @GetMapping("/parties")
    public String viewParties(){
        return "chef/partyOrders";
    }
    
    
    @GetMapping("/createOrder")
    public String createOrder(){
        return "chef/createOrder";
    }
}
