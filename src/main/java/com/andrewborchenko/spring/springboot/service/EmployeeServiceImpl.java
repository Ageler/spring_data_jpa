package com.andrewborchenko.spring.springboot.service;

import com.andrewborchenko.spring.springboot.dao.EmployeeRepository;
import com.andrewborchenko.spring.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    // все работает от SpringBootRepository также не нужно заботиться о транзакционности
    @Override
    // аналогия getAllEmployees()
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    // аналогия saveEmployee(employee) может как удалять так и изменять
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    // аналогия getEmployee(id)
    public Employee getEmployee(int id) {
        Employee employee = null;
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        // добавлять сюда exception
        if(optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();
        }
        return employee;
    }

    @Override
    // аналогия deleteEmployee(id)
    public void deleteEmployee(int id) { employeeRepository.deleteById(id); }

    @Override
    public List<Employee> findAllByName(String name) {
        return employeeRepository.findAllByName(name);
    }
}
