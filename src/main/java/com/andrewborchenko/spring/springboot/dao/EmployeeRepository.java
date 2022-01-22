package com.andrewborchenko.spring.springboot.dao;



import com.andrewborchenko.spring.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//ранее использованный класс EmployeeDAO
// JpaRepository<Employee - с этим entity работает БД, Integer - тип primary key у этого entity>
// JpaRepository предоставляет все CRUD операции для работы с БД автоматически

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // также можно прописать любой свой кастомный метод и соблюдая правила имени JPA
    // почти всегда подберут встроенный метод исходя из запроса
    public List<Employee> findAllByName(String name);
}
