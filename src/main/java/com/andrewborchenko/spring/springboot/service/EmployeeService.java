package com.andrewborchenko.spring.springboot.service;


import com.andrewborchenko.spring.springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployee(int id);
    void deleteEmployee(int id);
    List<Employee> findAllByName(String name);
}
