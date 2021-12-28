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
    public void addOccupation(Person person, Movie movie, Occupation occupation) {
        personService.addOccupation(person, occupation);
        movieService.addOccupation(movie, occupation);
    }

    @Override
    public void removeOccupation(Person person, Movie movie, Occupation occupation) {
        personService.removeOccupation(person, occupation);
        movieService.removeOccupation(movie, occupation);
    }

    @Override
    public void updateOccupation(Person person, Movie movie, Occupation occupation) {
        personService.updateOccupation(person, occupation);
        movieService.updateOccupation(movie, occupation);
    }

    @Override
    public void addOccupation(Person person, Episode episode, Occupation occupation) {
        personService.addOccupation(person, occupation);
        episodeService.addOccupation(episode, occupation);
    }

    @Override
    public void removeOccupation(Person person, Episode episode, Occupation occupation) {
        personService.removeOccupation(person, occupation);
        episodeService.removeOccupation(episode, occupation);
    }

    @Override
    public void updateOccupation(Person person, Episode episode, Occupation occupation) {
        personService.updateOccupation(person, occupation);
        episodeService.updateOccupation(episode, occupation);
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
