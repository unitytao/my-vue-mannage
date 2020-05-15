package com.liaolei.service;

import com.liaolei.entity.TAdmin;
import com.liaolei.entity.TUser;

import java.util.List;

public interface UserService {
    int addAdmin(TAdmin tAdmin);

    int addUser(TUser tUser);

    List<TUser> findByDepId(Integer depId);

    List<TUser> findAll();

    TUser findById(Integer id);

    TUser findByName(String name);

    TAdmin checkAccount(TAdmin tAdmin);

    Integer updateDepartAndPosition(Integer userId,Integer depId,Integer ptnId);

    Integer updatePosition(Integer userId,Integer ptnId);

    Integer setTestOver(Integer id);

    Integer setFired(Integer id);
}
