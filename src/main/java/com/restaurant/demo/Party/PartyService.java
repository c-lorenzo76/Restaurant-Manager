package com.restaurant.demo.Party;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian
 */
@Service
public class PartyService {
    
    @Autowired 
    private PartyRepository repo;
    
    public List<Party> getAllParties(){
        return repo.findAll();
    }
    
    public Party getParty(long partyId){
        return repo.getReferenceById(partyId);
    }
    
    public void deleteParty(long partyId){
        repo.deleteById(partyId);
    }
    
    public void saveParty(Party party){
        repo.save(party);
    }
}
