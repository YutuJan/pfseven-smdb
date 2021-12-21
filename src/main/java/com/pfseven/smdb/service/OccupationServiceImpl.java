package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.FilmographyRole;
import com.pfseven.smdb.domain.Occupation;
import com.pfseven.smdb.repository.OccupationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OccupationServiceImpl extends BaseServiceImpl<Occupation> implements OccupationService {
    private final OccupationRepository occupationRepository;

    @Override
    public void newOccupation(Occupation occupation) {

    }

    @Override
    public void removeOccupation(Occupation occupation) {

    }

    @Override
    JpaRepository<Occupation, Long> getRepository() {
        return occupationRepository;
    }

    @Override
    public List<Occupation> findAll(FilmographyRole role) {
        return null;
    }

    @Override
    public List<Occupation> getAll(FilmographyRole role) {
        return null;
    }
}
