package com.liaolei.mapper;

import com.liaolei.entity.TAdmin;
import com.liaolei.entity.TUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    int addAdmin(TAdmin tAdmin);

    int addUser(TUser tUser);

    TAdmin findByNameAndPwd(TAdmin tAdmin);

    TUser findById(Integer id);

    TUser findByName(String name);

    List<TUser> findByDepId(Integer depId);

    List<TUser> findAll();

    Integer updateDepartAndPosition(@Param("userId")Integer userId,@Param("depId")Integer depId,@Param("ptnId")Integer ptnId);

    Integer updatePosition(@Param("userId")Integer userId,@Param("ptnId")Integer ptnId);

    Integer setTestOver(Integer id);

    Integer setFired(Integer id);
}
