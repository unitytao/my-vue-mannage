package com.liaolei.daoImpl;

import com.liaolei.dao.PositionDao;
import com.liaolei.entity.Position;
import com.liaolei.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionDaoImpl implements PositionDao {
    @Autowired
    public PositionMapper positionMapper;

    @Override
    public List<Position> findAll() {
        return positionMapper.findAll();
    }

    @Override
    public Integer addPosition(Position position) {
        return positionMapper.addPosition(position);
    }

    @Override
    public Integer deletePosition(Integer id) {
        return positionMapper.deletePosition(id);
    }

    @Override
    public Integer updatePosition(Position position) {
        return positionMapper.updatePosition(position);
    }

    @Override
    public List<Position> findPositionByDepId(Integer id) {
        return positionMapper.findPositionByDepId(id);
    }

    @Override
    public Position findById(Integer id) {
        return positionMapper.findById(id);
    }

    @Override
    public Position findByName(String name) {
        return positionMapper.findByName(name);
    }
}
