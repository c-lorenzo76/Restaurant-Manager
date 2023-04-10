package com.restaurant.demo.Employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Updated: 03/31/2023
 * @author cristian
 */
@Service
public class EmployeeService {
  
    @Autowired
    private EmployeeRepository repo;
    
    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }
    
    public Employee getEmployee(long employeeID){
        return repo.getReferenceById(employeeID);
    }
    
    public void deleteEmployee(long employeeID){
        repo.deleteById(employeeID);
    }
    
    void saveEmployee(Employee employee){
        repo.save(employee);
    }
    
}
