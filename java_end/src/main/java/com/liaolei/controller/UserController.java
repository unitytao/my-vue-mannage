package com.liaolei.controller;

import com.liaolei.entity.TAdmin;
import com.liaolei.entity.TUser;
import com.liaolei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String entry() {
        return "login";
    }

    @RequestMapping("/check")
    @ResponseBody
    public String check(String account,String password) {     //登录
        TAdmin tAdmin = new TAdmin(account,password);
        if(userService.checkAccount(tAdmin) != null) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/register")
    @ResponseBody
    public String rigister(String account,String password){    //注册
        TAdmin tAdmin = new TAdmin(account,password);
        if(userService.addAdmin(tAdmin) == 1) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/add")
    @ResponseBody                                               //添加员工
    public String addUser(String name,String gender,String birthday,String idCard,Integer depId,Integer psnId) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        TUser tUser = new TUser(name,gender,sdf.parse(birthday),idCard,depId,psnId);
        if(userService.addUser(tUser) == 1) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<TUser> findAll() {                              //查询所有员工
        return userService.findAll();
    }

    @RequestMapping("/findByDepId")
    @ResponseBody                                               //按部门id查询
    public List<TUser> findUserByDepId(Integer depId) {         //按部门编号查询员工
        return userService.findByDepId(depId);
    }

    @RequestMapping("/findById")
    @ResponseBody                                               //按员工id查询
    public TUser findById(Integer id) {
        return userService.findById(id);
    }

    @RequestMapping("/findByName")
    @ResponseBody                                               //按员工姓名查询
    public TUser findByName(String name) {
        return userService.findByName(name);
    }

    @RequestMapping("/updateDAP")
    @ResponseBody                                               //修改员工部门和岗位
    public String updateDepartAndPosition(Integer userId,Integer depId,Integer ptnId) {
        if(userService.updateDepartAndPosition(userId,depId,ptnId) == 1) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/updatePosition")
    @ResponseBody                                               //仅修改员工岗位
    public String updatePosition(Integer userId,Integer ptnId) {
        if(userService.updatePosition(userId,ptnId) == 1) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/setTestOver")
    @ResponseBody                                               //设置试用期结束
    public String setTestOver(Integer id) {
        if(userService.setTestOver(id) == 1) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/setFired")
    @ResponseBody                                               //设置员工离职
    public String setFired(Integer id) {
        if(userService.setFired(id) == 1) {
            return "success";
        }
        return "fail";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
