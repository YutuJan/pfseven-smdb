package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.*;

import java.util.List;

public interface OccupationService extends BaseService<Occupation, Long> {
    void addPersonToMovieOccupation(Long personId, Long movieId, String roleType);

    void addPersonToMovieOccupation(String firstName, String lastName, String title, String roleType);

    void removePersonToMovieOccupation(Long personId, Long movieId, Long occupationId);

    void removePersonToMovieOccupation(String firstName, String lastName, String title, Long occupationId);

    void addPersonToEpisodeOccupation(Long personId, Long episodeId, String roleType);

    void addPersonToEpisodeOccupation(String firstName, String lastName, String title, String roleType);

    void removePersonToEpisodeOccupation(Long personId, Long episodeId, Long occupationId);

    void removePersonToEpisodeOccupation(String firstName, String lastName, String title, Long occupationId);

    List<Occupation> findAll(RoleType role);

    List<Occupation> getAll(RoleType role);
}
