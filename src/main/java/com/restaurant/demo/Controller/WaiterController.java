package com.restaurant.demo.Controller;

import com.restaurant.demo.Party.Party;
import com.restaurant.demo.Party.PartyService;
import com.restaurant.demo.PartyOrder.PartyOrder;
import com.restaurant.demo.PartyOrder.PartyOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author nino
 */

/**
 * A way to store images is to make a database that holds the information of where the images is stored in the project
 * Then make a static package that contains all of the images and have it so that it is called whenever you want to use by the name of what it's stored
 * in the data base 
 * 
 * so database table contains info on pic location in project 
 * the project in templates static contains all of the images
 * when you want to call the images have it so that it calls based on the database location thing 
 * @author cristian
 */

@Controller
@RequestMapping("/waiter")
public class WaiterController {
    
    @Autowired
    PartyService PartyService;
    
    @Autowired
    PartyOrderService PartyOrderService;
    
    @GetMapping("")
    public String viewWaiterHome(){
        return "waiter/waiterHome";
    }
    
    @GetMapping("/parties")
    public String viewParties(Model model){
        model.addAttribute("partyList", PartyService.getAllParties());
        return "waiter/partyOrders";
    }
    
    // deletes the order from the both databases "party" and "party_order"
    // NEED TO FIX THIS 
    // ITS DELETING RIGHT FROM PARTY BUT PARTY_ORDER IS NOT DELETING THE CORRECT THING
    // ITS DELETING BASED OFF THE ID OF THE "party_order" NOT BY THE "party_id"
    // NEED TO FIND WAY TO MAKE THAT WORK 
    @GetMapping("delete/id={partyId}")
    public String deleteParty(@PathVariable long partyId, Model model, Model model2){
        
        List<PartyOrder> list = PartyOrderService.getAllPartyOrders();
        
        for(PartyOrder items: list){
            if(items.getParty_id() == partyId){
                // need to find a way that it goes into the database and deletes every instance of the partyID 
                PartyOrderService.deletePartyOrder(partyId);
            }
        }
        
        PartyService.deleteParty(partyId);
        return "redirect:/waiter/parties";
    }
    
    @GetMapping("/view-order/id={partyId}")
    public String getPartyOrder(@PathVariable long partyId, Model model1, Model model2, Model model3){
        
        List<PartyOrder> list = PartyOrderService.getAllPartyOrders();
        double total =0;
        
        for(PartyOrder item : list){
            if((int)item.getParty_id() == (int)partyId){
               total += item.getItem_total() * item.getItem_quantity();
            }
        }
          
        model1.addAttribute("items", PartyOrderService.getAllPartyOrders());
        model2.addAttribute("total", total);
        model3.addAttribute("partyId", partyId);
        
        return "waiter/waiterViewOrder";
    }
        
    @PostMapping("/update")
    public String updateParty(Party party){
        PartyService.saveParty(party);
        return "redirect:/waiter/parties";
    }
    
    @GetMapping("/update-status/id={partyId}")
    public String updatePartyStatus(@PathVariable long partyId, Model model){
      model.addAttribute("party", PartyService.getParty(partyId));
      return "waiter/update-status";
    }
   
}
