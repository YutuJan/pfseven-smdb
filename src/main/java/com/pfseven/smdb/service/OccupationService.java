package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.RoleType;
import com.pfseven.smdb.domain.Occupation;

import java.util.List;

public interface OccupationService extends BaseService<Occupation, Long> {
    void newOccupation(Occupation occupation);

    void removeOccupation(Occupation occupation);

    List<Occupation> findAll(RoleType role);

    List<Occupation> getAll(RoleType role);
}
