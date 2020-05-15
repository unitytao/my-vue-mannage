package com.liaolei.service;

import com.liaolei.entity.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();

    Integer addPosition(Position position);

    Integer deletePosition(Integer id);

    Integer updatePosition(Position position);

    List<Position> findPositionByDepId(Integer id);

    Position findById(Integer id);

    Position findByName(String name);
}
