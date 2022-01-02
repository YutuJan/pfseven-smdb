package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.*;
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
    public void addOccupation(Person person, Movie movie, Occupation occupation) {

    }

    @Override
    public void removeOccupation(Person person, Movie movie, Occupation occupation) {

    }

    @Override
    public void updateOccupation(Person person, Movie movie, Occupation occupation) {

    }

    @Override
    public void addOccupation(Person person, Episode episode, Occupation occupation) {

    }

    @Override
    public void removeOccupation(Person person, Episode episode, Occupation occupation) {

    }

    @Override
    public void updateOccupation(Person person, Episode episode, Occupation occupation) {

    }

    @Override
    public List<Occupation> findAll(RoleType role) {
        return null;
    }

    @Override
    public List<Occupation> getAll(RoleType role) {
        return null;
    }

}
