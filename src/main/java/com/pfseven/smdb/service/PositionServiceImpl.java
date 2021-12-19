package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Position;
import com.pfseven.smdb.repository.BaseRepository;
import com.pfseven.smdb.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    BaseRepository<Position, Long> getRepository() {
        return positionRepository;
    }
}
