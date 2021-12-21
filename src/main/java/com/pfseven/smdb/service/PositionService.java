package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.FilmographyRole;
import com.pfseven.smdb.domain.Position;

import java.util.List;

public interface PositionService extends BaseService<Position, Long> {
    void newPosition(Position position);

    void removePosition(Position position);

    List<Position> findAll(FilmographyRole role);

    List<Position> getAll(FilmographyRole role);
}
