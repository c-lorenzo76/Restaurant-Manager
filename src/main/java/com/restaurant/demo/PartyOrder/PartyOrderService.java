package com.restaurant.demo.PartyOrder;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian
 */
@Service
public class PartyOrderService {
    
    @Autowired
    private PartyOrderRepository repo;
    
    public List<PartyOrder> getAllPartyOrders(){
       return repo.findAll(); 
    }
    
    public PartyOrder getPartyOrderItem(long partyOrderId){
        return repo.getReferenceById(partyOrderId);
    }
    
    public void deletePartyOrder(long partyOrderId){
        repo.deleteById(partyOrderId);
    }
    
    public void savePartyOrder(PartyOrder partyOrder){
        repo.save(partyOrder);
    }
    
    
}
