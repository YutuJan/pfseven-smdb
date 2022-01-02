package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.RoleType;
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
    public JpaRepository<Occupation, Long> getRepository() {
        return occupationRepository;
    }

    @Override
    public List<Occupation> findAll(RoleType role) {
        return null;
    }

}
