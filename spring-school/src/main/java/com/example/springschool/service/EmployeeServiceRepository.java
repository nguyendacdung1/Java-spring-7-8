package com.example.springschool.service;

import com.example.springschool.dto.ClassesDto;
import com.example.springschool.dto.EmployeeDto;
import com.example.springschool.entity.Employee;

import java.util.List;

public interface EmployeeServiceRepository {
    List<Employee> getAll();
    List<Employee> findByName(String name);

    Employee create(Employee employeeDto);
}
