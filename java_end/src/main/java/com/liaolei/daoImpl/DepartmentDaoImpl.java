package com.liaolei.daoImpl;

import com.liaolei.dao.DepartmentDao;
import com.liaolei.entity.Department;
import com.liaolei.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    @Autowired
    public DepartmentMapper departmentMapper;


    @Override
    public List<Department> findAll() {
        return departmentMapper.findAll();
    }

    @Override
    public Department findByName(String bmName) {
        return departmentMapper.findDepartmentByName(bmName);
    }

    @Override
    public Department findById(Integer id) {
        return departmentMapper.findDepartmentById(id);
    }

    @Override
    public Integer deleteById(Integer id) {
        return departmentMapper.deleteById(id);
    }

    @Override
    public Integer deletePositionByDepId(Integer id) {
        return departmentMapper.deletePositionByDepId(id);
    }

    @Override
    public Integer addDepartment(Department department) {
        return departmentMapper.addDepartment(department);
    }

    @Override
    public Integer updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }
}
