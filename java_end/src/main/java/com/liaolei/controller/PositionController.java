package com.liaolei.controller;

import com.liaolei.entity.Position;
import com.liaolei.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    public PositionService positionService;

    @RequestMapping("/add")
    @ResponseBody                                       //添加岗位
    public String addPosition(String gwName,Integer depId){
        Position position = new Position(gwName,depId);
        if(positionService.addPosition(position) == 1) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/findAll")
    @ResponseBody                                       //查询所有岗位
    public List<Position> findAll() {
        return positionService.findAll();
    }

    @RequestMapping("/findByDepId")
    @ResponseBody                                       //按部门id查询
    public List<Position> findByDepId(Integer depId) {
        return positionService.findPositionByDepId(depId);
    }

    @RequestMapping("/findById")
    @ResponseBody                                       //按岗位id查询
    public Position findById(Integer id) {
        return positionService.findById(id);
    }

    @RequestMapping("/findByName")
    @ResponseBody                                       //按岗位名称查询
    public Position findByName(String name) {
        return positionService.findByName(name);
    }

    @RequestMapping("/delete")
    @ResponseBody                                       //按id删除岗位
    public String deletePosition(Integer id) {
        if(positionService.deletePosition(id) == 1) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/update")
    @ResponseBody                                       //修改岗位信息
    public String updatePosition(Integer id,String gwName,Integer depId) {
        Position position = new Position(gwName,depId);
        position.setId(id);
        if(positionService.updatePosition(position) == 1) {
            return "success";
        }
        return "fail";
    }
}
