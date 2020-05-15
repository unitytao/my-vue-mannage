package com.liaolei.serviceImpl;

import com.liaolei.dao.PositionDao;
import com.liaolei.entity.Position;
import com.liaolei.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {
    @Autowired
    public PositionDao positionDao;

    @Override
    public List<Position> findAll() {
        return positionDao.findAll();
    }

    @Override
    public Integer addPosition(Position position) {
        return positionDao.addPosition(position);
    }

    @Override
    public Integer deletePosition(Integer id) {
        return positionDao.deletePosition(id);
    }

    @Override
    public Integer updatePosition(Position position) {
        return positionDao.updatePosition(position);
    }

    @Override
    public List<Position> findPositionByDepId(Integer id) {
        return positionDao.findPositionByDepId(id);
    }

    @Override
    public Position findById(Integer id) {
        return positionDao.findById(id);
    }

    @Override
    public Position findByName(String name) {
        return positionDao.findByName(name);
    }
}
