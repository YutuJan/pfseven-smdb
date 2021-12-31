package com.pfseven.smdb.controller;

import com.pfseven.smdb.domain.*;
import com.pfseven.smdb.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/occupation")
public class OccupationController extends AbstractController<Occupation> {
    private final OccupationService occupationService;
    private final PersonService personService;
    private final MovieService movieService;
    private final EpisodeService episodeService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addOccupation(@Valid @RequestBody final Person person,
                              @Valid @RequestBody final Movie movie,
                              @Valid @RequestBody final Occupation occupation) {
        if (personService.exists(person) && movieService.exists(movie)) {
            occupationService.addOccupation(person, movie, occupation);
        }
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeOccupation(@Valid @RequestBody final Person person,
                                 @Valid @RequestBody final Movie movie,
                                 @Valid @RequestBody final Occupation occupation) {
        if (personService.exists(person) && movieService.exists(movie)) {
            occupationService.removeOccupation(person, movie, occupation);
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOccupation(@Valid @RequestBody final Person person,
                                 @Valid @RequestBody final Movie movie,
                                 @Valid @RequestBody final Occupation occupation) {
        if (personService.exists(person) && movieService.exists(movie)) {
            occupationService.updateOccupation(person, movie, occupation);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addOccupation(@Valid @RequestBody final Person person,
                              @Valid @RequestBody final Episode episode,
                              @Valid @RequestBody final Occupation occupation) {
        if (personService.exists(person) && episodeService.exists(episode)) {
            occupationService.addOccupation(person, episode, occupation);
        }
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeOccupation(@Valid @RequestBody final Person person,
                                 @Valid @RequestBody final Episode episode,
                                 @Valid @RequestBody final Occupation occupation) {
        if (personService.exists(person) && episodeService.exists(episode)) {
            occupationService.removeOccupation(person, episode, occupation);
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOccupation(@Valid @RequestBody final Person person,
                                 @Valid @RequestBody final Episode episode,
                                 @Valid @RequestBody final Occupation occupation) {
        if (personService.exists(person) && episodeService.exists(episode)) {
            occupationService.updateOccupation(person, episode, occupation);
        }
    }

    @Override
    protected BaseService<Occupation, Long> getService() {
        return occupationService;
    }
}
