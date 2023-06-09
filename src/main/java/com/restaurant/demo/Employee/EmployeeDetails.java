package com.restaurant.demo.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author cristian
 */
public class EmployeeDetails implements UserDetails{
    
    
    private Employee emp;
    
    public EmployeeDetails(Employee emp){
       this.emp = emp;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(emp.getTitle().toString()));
        
        return authorities; 
   }

    @Override
    public String getPassword() {
     return emp.getPassword();
    }

    @Override
    public String getUsername() {
        return emp.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
           return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
