package com.liaolei.serviceImpl;

import com.liaolei.dao.DepartmentDao;
import com.liaolei.entity.Department;
import com.liaolei.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public Department findByName(String bmName) {
        return departmentDao.findByName(bmName);
    }

    @Override
    public Department findById(Integer id) {
        return departmentDao.findById(id);
    }

    @Override
    public Integer deleteById(Integer id) {
        return departmentDao.deleteById(id);
    }

    @Override
    public Integer deletePositionByDepId(Integer id) {
        return departmentDao.deletePositionByDepId(id);
    }

    @Override
    public Integer addDepartment(Department department) {
        return departmentDao.addDepartment(department);
    }

    @Override
    public Integer updateDepartment(Department department) {
        return departmentDao.updateDepartment(department);
    }
}
