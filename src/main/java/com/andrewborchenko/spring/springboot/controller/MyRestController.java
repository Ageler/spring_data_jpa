package com.andrewborchenko.spring.springboot.controller;

import com.andrewborchenko.spring.springboot.entity.Employee;
import com.andrewborchenko.spring.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/*согласно нормам для каждой команды будет содержаться в url /api*/
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    /*так как получение всех работников это get запрос
     с помощью jackson будет собран JSON*/
    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }
    /*запрос get где вместо id может быть id любого работника*/
    @GetMapping("/employees/{id}")
    //*аннотация PathVariable нужна для получения id работника из url адреса запроса
    //employees/{id}
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    //*связываем request /employees(post) с методом addNewEmployee*//*
    @PostMapping("/employees")
    // при помощи аннотации @RequestBody jackson и spring конвертируют запрос в
    // объект Employee и извлекают его из post запроса
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        // добавление нового в базу не будет так как service uses method saveOrUpdate
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted";
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name) {
        List<Employee> employees = employeeService.findAllByName(name);
        return employees;
    }
}
