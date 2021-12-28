package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.*;

import java.util.List;

public interface OccupationService extends BaseService<Occupation, Long> {
    void addOccupation(Person person, Movie movie, Occupation occupation);

    void removeOccupation(Person person, Movie movie, Occupation occupation);

    void updateOccupation(Person person, Movie movie, Occupation occupation);

    void addOccupation(Person person, Episode episode, Occupation occupation);

    void removeOccupation(Person person, Episode episode, Occupation occupation);

    void updateOccupation(Person person, Episode episode, Occupation occupation);

    List<Occupation> findAll(RoleType role);

    List<Occupation> getAll(RoleType role);
}
