package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Person;
import com.pfseven.smdb.domain.Occupation;

public interface PersonService extends BaseService<Person, Long> {
    Person get(String firstName, String lastName);

    Person find(String firstName, String lastName);

    void addOccupation(Person person, Occupation occupation);

    void removeOccupation(Person person, Occupation occupation);

    void addPersonToMovieOccupation(Long personId, Long movieId, String roleType);

    void addPersonToMovieOccupation(String firstName, String lastName, String title, String roleType);

    void removePersonToMovieOccupation(Long personId, Long movieId, String roleType);

    void removePersonToMovieOccupation(String firstName, String lastName, String title, String roleType);

    void addPersonToEpisodeOccupation(Long personId, Long episodeId, String roleType);

    void addPersonToEpisodeOccupation(String firstName, String lastName, String title, String roleType);

    void removePersonToEpisodeOccupation(Long personId, Long episodeId, String roleType);

    void removePersonToEpisodeOccupation(String firstName, String lastName, String title, String roleType);
}
