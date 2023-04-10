package com.restaurant.demo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author cristian
 */
@Controller 
public class InitialController {
    
    @GetMapping("/")
    public String initial() {
        return "initial/initialPage";
        
    }
    
    @GetMapping("/home")
    public String home(){
        return "initial/initialPage";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @GetMapping("/403")
    public String _403(){
        return "403";
    }
    
   

}
