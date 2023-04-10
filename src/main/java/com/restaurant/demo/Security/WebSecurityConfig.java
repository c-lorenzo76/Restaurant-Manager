package com.restaurant.demo.Security;

import com.restaurant.demo.Employee.EmployeeDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author cristian
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    @Bean 
    public UserDetailsService userDetailsService(){
        return new EmployeeDetailsService();  
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    
    
    @Bean 
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
          http
                .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/","/home").permitAll()
                 
                .requestMatchers("/manager/**").hasAnyAuthority("MANAGER")
                .requestMatchers("/waiter/**").hasAnyAuthority("WAITER")
                .requestMatchers("/chef/**").hasAnyAuthority("CHEF")
                .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                .loginPage("/login")
                .permitAll()
                ).exceptionHandling((x) -> x.accessDeniedPage("/403"))
                .logout((logout) -> logout.permitAll());
                        

        return http.build();
      
    }
     
}


