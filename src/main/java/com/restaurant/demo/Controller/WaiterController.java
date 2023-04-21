package com.restaurant.demo.Controller;

import com.restaurant.demo.Menu.Menu;
import com.restaurant.demo.Menu.MenuService;
import com.restaurant.demo.Party.Party;
import com.restaurant.demo.Party.PartyService;
import com.restaurant.demo.PartyOrder.PartyOrder;
import com.restaurant.demo.PartyOrder.PartyOrderService;
import com.restaurant.demo.PartyOrder.PartyOrderStatus;
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
 * @author cristian
 *
 */



@Controller
@RequestMapping("/waiter")
public class WaiterController {
    
    @Autowired MenuService MenuService;
    
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
        return "waiter/waiterPartyOrders";
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
    
    @GetMapping("/new-party")
    public String newParty(Model model){
        return "waiter/waiterNewParty";
    }
    
    @PostMapping("/create-party")
    public String createNewParty(Party party){
        PartyService.saveParty(party);
        return "redirect:/waiter/parties";
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
    
    
    @GetMapping("/new-item/id={partyId}")
    public String addItemToOrder(@PathVariable long partyId, Model model){
        model.addAttribute("listMenu", MenuService.getAllMenuItems());
        model.addAttribute("partyCart", PartyOrderService.getAllPartyOrders());
        model.addAttribute("partyId", partyId );
        
        return "waiter/waiterAddToOrder";
    }
    
    @GetMapping("/add-item")
    public String addItem(PartyOrder item){
        PartyOrderService.savePartyOrder(item);
        return "redirect:/waiter/parties";
    }
    
    @GetMapping("/add-toOrder/{itemId}{partyId}")
    public String addItemToOrder(@PathVariable int itemId, @PathVariable long partyId, Model model){
        
        String item_name = null;
        String party_name = null;
        
        double item_total = 0;
        
        
        List<Menu> itemList = MenuService.getAllMenuItems();
        List<Party> partyList = PartyService.getAllParties();
        
        for(Menu item : itemList){
            if(itemId == item.getId()){
                item_name = item.getItemName();
                item_total = item.getPrice();
            }
        }
        
        for(Party party : partyList){
            if(partyId == party.getId()){
                party_name = party.getParty_name();
            }
        }
        
        PartyOrder itemAdd = new PartyOrder();
        itemAdd.setItem_id(itemId);
        itemAdd.setItem_name(item_name);
        itemAdd.setParty_id(partyId);
        itemAdd.setParty_name(party_name);
        itemAdd.setItem_status(PartyOrderStatus.NOTREADY);
        itemAdd.setItem_quantity(1);
        itemAdd.setItem_total(item_total);
        
        PartyOrderService.savePartyOrder(itemAdd);
        
        return "redirect:/waiter/parties";
        
        
    }
    
    
    @GetMapping("delete/id={partyId}")
    public String deleteParty(@PathVariable long partyId, Model model, Model model2){
        
        List<PartyOrder> list = PartyOrderService.getAllPartyOrders();
        
        for(PartyOrder items: list){
            if(items.getParty_id() == partyId){
                
                PartyOrderService.deletePartyOrder(items.getId());
            }
        }
        
        PartyService.deleteParty(partyId);
        return "redirect:/waiter/parties";
    }
   
}
