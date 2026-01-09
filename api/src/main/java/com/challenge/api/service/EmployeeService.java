package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private List<Employee> employees;

    public EmployeeService() {
        employees = new ArrayList<>();

        Employee emp1 = new EmployeeImpl();
        emp1.setUuid(UUID.randomUUID());
        emp1.setFirstName("John");
        emp1.setLastName("Doe");
        emp1.setFullName("John Doe");
        emp1.setSalary(50000);
        emp1.setAge(30);
        emp1.setJobTitle("Software Engineer");
        emp1.setEmail("email@mail.com");
        emp1.setContractHireDate(java.time.Instant.now());
        employees.add(emp1);
    }

    public List<Employee> getAllEmployees() {
        // Implement logic to retrieve all employees
        return employees; // Placeholder
    }

    public Employee getEmployeeByUuid(UUID uuid) {
        // Implement logic to retrieve an employee by UUID
        return employees.stream()
                .filter(emp -> emp.getUuid().equals(uuid))
                .findFirst()
                .orElse(null); // Placeholder
    }

    public Employee createEmployee(Object employeeData) {
        // Implement logic to create a new employee
        return null; // Placeholder
    }
}
