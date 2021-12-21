package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.FilmographyRole;
import com.pfseven.smdb.domain.Position;
import com.pfseven.smdb.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl extends BaseServiceImpl<Position> implements PositionService {
    private final PositionRepository positionRepository;

    @Override
    public void newPosition(Position position) {

    }

    @Override
    public void removePosition(Position position) {

    }

    @Override
    JpaRepository<Position, Long> getRepository() {
        return positionRepository;
    }

    @Override
    public List<Position> findAll(FilmographyRole role) {
        return null;
    }

    @Override
    public List<Position> getAll(FilmographyRole role) {
        return null;
    }
}
