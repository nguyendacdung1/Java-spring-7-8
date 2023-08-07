package com.example.springschool.service;

import com.example.springschool.dto.ClassesDto;

import java.util.List;


public interface ClassServiceRepository {
    List<ClassesDto> findAll();
    List<ClassesDto> gets(ClassesDto criteria);

    ClassesDto createNewItem(ClassesDto classesDto);
}
