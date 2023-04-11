package com.restaurant.demo.Controller;

import com.restaurant.demo.Party.PartyService;
import com.restaurant.demo.PartyOrder.PartyOrder;
import com.restaurant.demo.PartyOrder.PartyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author cristian
 * 
 */

// WORK ON FINISHING UP THE USE CASES FOR CHEF
// JUST NEED TO UPDATE STATUS OF A ORDER ITEM WHICH IS PARTYORDER


@Controller
@RequestMapping("/chef")
public class ChefController {
    
    @Autowired
    PartyService PartyService;
    
    @Autowired
    PartyOrderService PartyOrderService;
    
    @GetMapping("")
    public String viewChefHome(){
        return "chef/chefHome";
    }
    
    @GetMapping("/view-orders")
    public String viewPartyOrders(Model model){
        model.addAttribute("partyList", PartyService.getAllParties());
        return "chef/chefPartyOrders";
    }
    
    @GetMapping("/view-order/id={partyId}")
    public String getPartyOrder(@PathVariable long partyId, Model model , Model model2){
        
        model.addAttribute("items", PartyOrderService.getAllPartyOrders());
        model2.addAttribute("partyId", partyId);
        
        return "chef/chefViewOrder";
    }
    
    @GetMapping("update-status/id={itemId}")
    public String updatePartyStatus(@PathVariable long itemId, Model model){
        model.addAttribute("item", PartyOrderService.getPartyOrderItem(itemId));
        return "chef/chefUpdateStatus";
    }
    
    @PostMapping("/update")
    public String updateItemStatus(PartyOrder item){
        PartyOrderService.savePartyOrder(item);
        return "redirect:/chef/view-orders";
    }
    
    @GetMapping("/createOrder")
    public String createOrder(){
        return "chef/createOrder";
    }
}
