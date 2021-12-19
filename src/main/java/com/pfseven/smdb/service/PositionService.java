package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Position;

public interface PositionService extends BaseService<Position, Long> {
    void newPosition(Position position);

    void removePosition(Position position);
}
