package com.restaurant.demo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

/**
 *
 * @author cristian
 */
public class EmployeeDetailsService implements UserDetailsService{
    
    @Autowired
    private EmployeeRepository repo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Employee emp = repo.findByUsername(username);
        
        
        if(emp == null){
        throw new UnsupportedOperationException("No user found with the username");    
        }
        
        return new EmployeeDetails(emp);
        
    }
    
    

}
