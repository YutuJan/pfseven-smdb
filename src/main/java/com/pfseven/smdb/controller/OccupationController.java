package com.pfseven.smdb.controller;

import com.pfseven.smdb.domain.*;
import com.pfseven.smdb.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/occupations")
public class OccupationController extends AbstractController<Occupation> {
    private final OccupationService occupationService;

    @PostMapping("/person_id/{person_id}/movie_id/{movie_id}/role_type/{role_type}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addPersonToMovieOccupation(@PathVariable("person_id") final Long personId,
                                           @PathVariable("movie_id") final Long movieId,
                                           @PathVariable("role_type") final String roleType) {
        occupationService.addPersonToMovieOccupation(personId, movieId, roleType);
    }

    @DeleteMapping("/person_id/{person_id}/movie_id/{movie_id}/occupation_id/{occupation_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePersonToMovieOccupation(@PathVariable("person_id") final Long personId,
                                              @PathVariable("movie_id") final Long movieId,
                                              @PathVariable("occupation_id") final Long occupationId) {
        occupationService.removePersonToMovieOccupation(personId, movieId, occupationId);
    }

    @PostMapping("/person_id/{person_id}/episode_id/{episode_id}/role_type/{role_type}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addPersonToEpisodeOccupation(@PathVariable("person_id") final Long personId,
                                             @PathVariable("episode_id") final Long episodeId,
                                             @PathVariable("role_type") final String roleType) {
        occupationService.addPersonToEpisodeOccupation(personId, episodeId, roleType);
    }

    @DeleteMapping("/person_id/{person_id}/episode_id/{episode_id}/occupation_id/{occupation_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePersonToEpisodeOccupation(@PathVariable("person_id") final Long personId,
                                                @PathVariable("episode_id") final Long episodeId,
                                                @PathVariable("occupation_id") final Long occupationId) {
        occupationService.removePersonToEpisodeOccupation(personId, episodeId, occupationId);
    }

    @PostMapping("/person_fn/{person_fn}/person_ln/{person_ln}/movie_title/{movie_title}/role_type/{role_type}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addPersonToMovieOccupation(@PathVariable("person_fn") final String firstName,
                                           @PathVariable("person_ln") final String lastName,
                                           @PathVariable("movie_title") final String title,
                                           @PathVariable("role_type") final String roleType) {
        occupationService.addPersonToMovieOccupation(firstName, lastName, title, roleType);
    }

    @DeleteMapping("/person_fn/{person_fn}/person_ln/{person_ln}/movie_title/{movie_title}/occupation_id/{occupation_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePersonToMovieOccupation(@PathVariable("person_fn") final String firstName,
                                              @PathVariable("person_ln") final String lastName,
                                              @PathVariable("movie_title") final String title,
                                              @PathVariable("occupation_id") final Long occupationId) {
        occupationService.removePersonToMovieOccupation(firstName, lastName, title, occupationId);
    }

    @PostMapping("/person_fn/{person_fn}/person_ln/{person_ln}/episode_title/{episode_title}/role_type/{role_type}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addPersonToEpisodeOccupation(@PathVariable("person_fn") final String firstName,
                                             @PathVariable("person_ln") final String lastName,
                                             @PathVariable("episode_title") final String title,
                                             @PathVariable("role_type") final String roleType) {
        occupationService.addPersonToEpisodeOccupation(firstName, lastName, title, roleType);
    }

    @DeleteMapping("/person_fn/{person_fn}/person_ln/{person_ln}/episode_title/{episode_title}/occupation_id/{occupation_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePersonToEpisodeOccupation(@PathVariable("person_fn") final String firstName,
                                                @PathVariable("person_ln") final String lastName,
                                                @PathVariable("episode_title") final String title,
                                                @PathVariable("occupation_id") final Long occupationId) {
        occupationService.removePersonToEpisodeOccupation(firstName, lastName, title, occupationId);
    }

    @Override
    protected BaseService<Occupation, Long> getService() {
        return occupationService;
    }
}
