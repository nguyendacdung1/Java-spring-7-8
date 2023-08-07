package com.example.springschool.controller;

import com.example.springschool.dto.ClassesDto;
import com.example.springschool.dto.EmployeeDto;
import com.example.springschool.entity.Employee;
import com.example.springschool.service.ClassServiceRepository;
import com.example.springschool.service.EmployeeServiceRepository;
import com.example.springschool.service.impl.ClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "api/v1")
public class EmployeeController extends BaseController {
    @Autowired
    private EmployeeServiceRepository employeeService;

    @GetMapping(value= "/employees")
    public ResponseEntity<?> index(){
        return ResponseEntity.ok(employeeService.getAll());
    }
    @PostMapping(value="/employees/create" )
    public ResponseEntity<?> create(@ModelAttribute Employee employee){
        return ResponseEntity.ok(employeeService.create(employee));
    };

}
