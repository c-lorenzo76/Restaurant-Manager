package com.restaurant.demo.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Updated: 03/31/2023
 * @author cristian
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    public Employee findByUsername(String username);
}
