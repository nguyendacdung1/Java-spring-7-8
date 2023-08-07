package com.example.springschool.service.impl;

import com.example.springschool.dto.LoginResponseDto;
import com.example.springschool.entity.Employee;
import com.example.springschool.entity.User;
import com.example.springschool.repo.EmployeeRepository;
import com.example.springschool.repo.UserRepository;
import com.example.springschool.service.EmployeeServiceRepository;
import com.example.springschool.service.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService extends A_Service implements EmployeeServiceRepository {
    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> findByName(String name){
        return employeeRepository.findByName(name);
    }

    @Override
    public Employee create(Employee employee) {
        if (employee != null && employee.getId() == 0) {
            // Các xử lý hoặc kiểm tra hợp lệ khác tùy theo yêu cầu

            return employeeRepository.save(employee);
        }
        return null;
    }


}
