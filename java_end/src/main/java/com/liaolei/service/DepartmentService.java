package com.liaolei.service;

import com.liaolei.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    Department findByName(String bmName);

    Department findById(Integer id);

    Integer deleteById(Integer id);

    Integer deletePositionByDepId(Integer id);

    Integer addDepartment(Department department);

    Integer updateDepartment(Department department);
}
