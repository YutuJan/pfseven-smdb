package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.FilmographyRole;
import com.pfseven.smdb.domain.Occupation;

import java.util.List;

public interface OccupationService extends BaseService<Occupation, Long> {
    void newOccupation(Occupation occupation);

    void removeOccupation(Occupation occupation);

    List<Occupation> findAll(FilmographyRole role);

    List<Occupation> getAll(FilmographyRole role);
}
