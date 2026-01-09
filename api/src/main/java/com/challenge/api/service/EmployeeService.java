package com.challenge.api.service;

import com.challenge.api.dto.CreateEmployeeRequest;
import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    /** List to store all employees would be replaced by Database*/
    private List<Employee> employees;

    /**
     * Constructor initializes with mock data
     */
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

    /**
     *
     * @return List of all Employees
     */
    public List<Employee> getAllEmployees() {
        return employees;
    }

    /**
     *
     * @param uuid provided UUID from Controller input
     * @return Employee matching UUID if exists or null
     */
    public Employee getEmployeeByUuid(UUID uuid) {
        return employees.stream()
                .filter(emp -> emp.getUuid().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    /**
     *
     * @param employeeData CreateEmployeeRequest DTO from Controller
     * @return Newly created Employee
     */
    public Employee createEmployee(CreateEmployeeRequest employeeData) {
        Employee employee = new EmployeeImpl();

        // Set fields that could possibly be internal fields
        employee.setUuid(UUID.randomUUID());
        employee.setContractHireDate(java.time.Instant.now());

        // Set fields the client is possibly allowed to provide
        employee.setFirstName(employeeData.getFirstName());
        employee.setLastName(employeeData.getLastName());
        employee.setFullName(
                employeeData.getFullName() != null
                        ? employeeData.getFullName()
                        : employeeData.getFirstName() + " " + employeeData.getLastName());
        employee.setSalary(employeeData.getSalary());
        employee.setAge(employeeData.getAge());
        employee.setJobTitle(employeeData.getJobTitle());
        employee.setEmail(employeeData.getEmail());

        employees.add(employee);

        return employee;
    }
}
