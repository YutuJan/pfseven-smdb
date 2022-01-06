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
    private final PersonService personService;
    private final MovieService movieService;
    private final EpisodeService episodeService;

    @Override
    JpaRepository<Occupation, Long> getRepository() {
        return occupationRepository;
    }

    @Override
    public void addPersonToMovieOccupation(Long personId, Long movieId, String roleType) {
        Person person = personService.find(personId);
        Movie movie = movieService.find(movieId);
        Occupation occupation = Occupation.builder()
                .person(person)
                .videoEntertainment(movie)
                .occupation(RoleType.valueOf(roleType))
                .build();

        addOccupation(person, movie, occupation);
    }

    @Override
    public void addPersonToMovieOccupation(String firstName,
                                           String lastName,
                                           String title,
                                           String roleType) {
        Person person = personService.find(firstName, lastName);
        Movie movie = movieService.find(title);
        Occupation occupation = Occupation.builder()
                .person(person)
                .videoEntertainment(movie)
                .occupation(RoleType.valueOf(roleType))
                .build();

        addOccupation(person, movie, occupation);
    }

    @Override
    public void removePersonToMovieOccupation(Long personId,
                                              Long movieId,
                                              Long occupationId) {
        Person person = personService.find(personId);
        Movie movie = movieService.find(movieId);
        Occupation occupation = find(occupationId);

        removeOccupation(person, movie, occupation);
    }

    @Override
    public void removePersonToMovieOccupation(String firstName,
                                              String lastName,
                                              String title,
                                              Long occupationId) {
        Person person = personService.find(firstName, lastName);
        Movie movie = movieService.find(title);
        Occupation occupation = find(occupationId);

        removeOccupation(person, movie, occupation);
    }

    @Override
    public void addPersonToEpisodeOccupation(Long personId,
                                             Long episodeId,
                                             String roleType) {
        Person person = personService.find(personId);
        Episode episode = episodeService.find(episodeId);
        Occupation occupation = Occupation.builder()
                .person(person)
                .videoEntertainment(episode)
                .occupation(RoleType.valueOf(roleType))
                .build();

        addOccupation(person, episode, occupation);
    }

    @Override
    public void addPersonToEpisodeOccupation(String firstName,
                                             String lastName,
                                             String title,
                                             String roleType) {
        Person person = personService.find(firstName, lastName);
        Episode episode = episodeService.find(title);
        Occupation occupation = Occupation.builder()
                .person(person)
                .videoEntertainment(episode)
                .occupation(RoleType.valueOf(roleType))
                .build();

        addOccupation(person, episode, occupation);
    }

    @Override
    public void removePersonToEpisodeOccupation(Long personId,
                                                Long episodeId,
                                                Long occupationId) {
        Person person = personService.find(personId);
        Episode episode = episodeService.find(episodeId);
        Occupation occupation = find(occupationId);

        removeOccupation(person, episode, occupation);
    }

    @Override
    public void removePersonToEpisodeOccupation(String firstName,
                                                String lastName,
                                                String title,
                                                Long occupationId) {
        Person person = personService.find(firstName, lastName);
        Episode episode = episodeService.find(title);
        Occupation occupation = find(occupationId);

        removeOccupation(person, episode, occupation);
    }

    private void addOccupation(Person person, Movie movie, Occupation occupation) {
        create(occupation);
        personService.addOccupation(person, occupation);
        movieService.addOccupation(movie, occupation);
    }

    private void addOccupation(Person person, Episode episode, Occupation occupation) {
        create(occupation);
        personService.addOccupation(person, occupation);
        episodeService.addOccupation(episode, occupation);
    }

    private void removeOccupation(Person person, Movie movie, Occupation occupation) {
        personService.removeOccupation(person, occupation);
        movieService.removeOccupation(movie, occupation);
        delete(occupation);
    }

    private void removeOccupation(Person person, Episode episode, Occupation occupation) {
        personService.removeOccupation(person, occupation);
        episodeService.removeOccupation(episode, occupation);
        delete(occupation);
    }
}
