package com.liaolei.mapper;

import com.liaolei.entity.Position;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PositionMapper {
    List<Position> findAll();

    Integer addPosition(Position position);

    Integer deletePosition(Integer id);

    Integer updatePosition(Position position);

    List<Position> findPositionByDepId(Integer id);

    Position findById(Integer id);

    Position findByName(String name);
}
