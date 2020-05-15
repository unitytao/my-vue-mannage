package com.liaolei.serviceImpl;

import com.liaolei.dao.UserDao;
import com.liaolei.entity.TAdmin;
import com.liaolei.entity.TUser;
import com.liaolei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //添加事务
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int addAdmin(TAdmin tAdmin) {
        return userDao.addAdmin(tAdmin);
    }

    @Override
    public int addUser(TUser tUser) {
        return userDao.addUser(tUser);
    }

    @Override
    public List<TUser> findByDepId(Integer depId) {
        return userDao.findByDepId(depId);
    }

    @Override
    public List<TUser> findAll() {
        return userDao.findAll();
    }

    @Override
    public TUser findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public TUser findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public TAdmin checkAccount(TAdmin tAdmin) {
        return userDao.checkAccount(tAdmin);
    }

    @Override
    public Integer updateDepartAndPosition(Integer userId, Integer depId, Integer ptnId) {
        return userDao.updateDepartAndPosition(userId,depId,ptnId);
    }

    @Override
    public Integer updatePosition(Integer userId, Integer ptnId) {
        return userDao.updatePosition(userId,ptnId);
    }

    @Override
    public Integer setTestOver(Integer id) {
        return userDao.setTestOver(id);
    }

    @Override
    public Integer setFired(Integer id) {
        return userDao.setFired(id);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
