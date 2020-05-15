package com.liaolei.daoImpl;

import com.liaolei.dao.UserDao;
import com.liaolei.entity.TAdmin;
import com.liaolei.entity.TUser;
import com.liaolei.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addAdmin(TAdmin tAdmin) {
        return userMapper.addAdmin(tAdmin);
    }

    @Override
    public int addUser(TUser tUser) {
        return userMapper.addUser(tUser);
    }

    @Override
    public List<TUser> findByDepId(Integer depId) {
        return userMapper.findByDepId(depId);
    }

    @Override
    public List<TUser> findAll() {
        return userMapper.findAll();
    }

    @Override
    public TUser findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public TUser findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public TAdmin checkAccount(TAdmin tAdmin) {
        return userMapper.findByNameAndPwd(tAdmin);
    }

    @Override
    public Integer updateDepartAndPosition(Integer userId, Integer depId, Integer ptnId) {
        return userMapper.updateDepartAndPosition(userId,depId,ptnId);
    }

    @Override
    public Integer updatePosition(Integer userId, Integer ptnId) {
        return userMapper.updatePosition(userId,ptnId);
    }

    @Override
    public Integer setTestOver(Integer id) {
        return userMapper.setTestOver(id);
    }

    @Override
    public Integer setFired(Integer id) {
        return userMapper.setFired(id);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
