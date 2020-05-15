package com.liaolei.mapper;

import com.liaolei.entity.Department;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DepartmentMapper {
    List<Department> findAll();

    Department findDepartmentByName(String bmName);

    Department findDepartmentById(Integer id);

    Integer deleteById(Integer id);

    Integer deletePositionByDepId(Integer id);

    Integer addDepartment(Department department);

    Integer updateDepartment(Department department);

}
