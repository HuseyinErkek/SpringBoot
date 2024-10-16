package com.huseyinerkek.config;

import com.huseyinerkek.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public List<Employee> employeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1","Hüseyin","Erkek"));
        employeeList.add(new Employee("2","Edefiye","Erkek"));
        employeeList.add(new Employee("3","Melisa","Durak"));
        employeeList.add(new Employee("4","Hüseyin","Durak"));
        return employeeList;
    }
}
