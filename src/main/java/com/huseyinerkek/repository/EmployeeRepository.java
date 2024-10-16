package com.huseyinerkek.repository;

import com.huseyinerkek.model.Employee;
import com.huseyinerkek.model.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeesList() {
        return employeeList;
    }

    public Employee getEmployeeById(String id) {
        Employee findemployee = null;
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                findemployee = employee;
                break;
            }
        }
        return findemployee;
    }

    public List<Employee> getEmployeeWithParam(String firstName, String lastName) {
        List<Employee> employeeWithParam = new ArrayList<>();
        if (firstName == null && lastName == null) {
            return employeeList;
        }
        for (Employee employee : employeeList) {
            if (firstName != null && lastName != null) {
                if (firstName.equalsIgnoreCase(employee.getFirstName()) && lastName.equalsIgnoreCase(employee.getLastName())) {
                    employeeWithParam.add(employee);
                }
            }
            if (firstName == null && lastName != null) {
                if (employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeWithParam.add(employee);
                }
            }
            if (lastName == null && firstName != null) {
                if (employee.getFirstName().equalsIgnoreCase(firstName)) {
                    employeeWithParam.add(employee);
                }
            }
        }
        return employeeWithParam;
    }

    public Employee saveEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public boolean deleteEmployee(String id) {
        Employee deteleEmployee = null;
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                deteleEmployee = employee;
                break;
            }
        }
        if (deteleEmployee == null) {
            return false;
        }
        employeeList.remove(deteleEmployee);
        return true;

    }

    private Employee findEmployeeById(String id) {
        Employee findemployee = null;
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                findemployee = employee;
                break;
            }
        }
            return findemployee;
    }

    public Employee updateEmployee(String id, UpdateEmployeeRequest request) {
        Employee findEmployee = findEmployeeById(id);
        Employee updatedEmployee = null;
        if (findEmployee != null) {
            deleteEmployee(id);
            updatedEmployee = new Employee();
            updatedEmployee.setId(id);
            updatedEmployee.setFirstName(request.getFirstName());
            updatedEmployee.setLastName(request.getLastName());
            employeeList.add(updatedEmployee);
        }
        return updatedEmployee;
    }
}
