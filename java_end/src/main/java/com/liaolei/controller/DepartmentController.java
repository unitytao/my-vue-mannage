package com.liaolei.controller;

import com.liaolei.entity.Department;
import com.liaolei.service.DepartmentService;
import com.liaolei.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/depart")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/findAll")
    @ResponseBody                                           //查询所有部门
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @RequestMapping("/findByName")
    @ResponseBody                                           //按部门名称查询
    public Department findByName(String bmName) {           //按名称查询部门
        return departmentService.findByName(bmName);
    }

    @RequestMapping("/findById")
    @ResponseBody                                           //按部门id查询
    public Department findById(Integer id) {                //按id查询部门
        return departmentService.findById(id);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteDep(Integer id) {                   //按id删除部门
        if(departmentService.deleteById(id) > 0 && departmentService.deletePositionByDepId(id) > 0) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/add")
    @ResponseBody                                           //添加部门
    public String addDepartment(String bmName,Integer superiorId) {
        Department department = new Department();
        department.setBmName(bmName);
        department.setSuperiorId(superiorId);
        if(departmentService.addDepartment(department) == 1) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/update")
    @ResponseBody                                           //修改部门信息
    public String updateDepartment(Integer id,String bmName,Integer superiorId) {
        Department department = new Department();
        department.setId(id);
        department.setBmName(bmName);
        department.setSuperiorId(superiorId);
        if(departmentService.updateDepartment(department) == 1) {
            return "success";
        }
        return "fail";
    }
}
