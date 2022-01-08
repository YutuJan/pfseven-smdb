package com.pfseven.smdb.controller;

import com.pfseven.smdb.domain.Movie;
import com.pfseven.smdb.service.BaseService;
import com.pfseven.smdb.service.MovieService;
import com.pfseven.smdb.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController extends AbstractController<Movie> {
    private final MovieService movieService;

    @GetMapping("/find/{title}")
    public ResponseEntity<ApiResponse<Movie>> find(@PathVariable final String title) {
        return ResponseEntity.ok(ApiResponse.<Movie>builder().data(movieService.find(title)).build());
    }

    @GetMapping("/get/{title}")
    public ResponseEntity<ApiResponse<Movie>> get(@PathVariable final String title) {
        return ResponseEntity.ok(ApiResponse.<Movie>builder().data(movieService.get(title)).build());
    }

    @PostMapping("/person_id/{person_id}/movie_id/{movie_id}/role_type/{role_type}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addPersonToMovieOccupation(@PathVariable("person_id") final Long personId,
                                           @PathVariable("movie_id") final Long movieId,
                                           @PathVariable("role_type") final String roleType) {
        movieService.addPersonToMovieOccupation(personId, movieId, roleType);
    }

    @DeleteMapping("/person_id/{person_id}/movie_id/{movie_id}/role_type/{role_type}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePersonToMovieOccupation(@PathVariable("person_id") final Long personId,
                                              @PathVariable("movie_id") final Long movieId,
                                              @PathVariable("role_type") final String roleType) {
        movieService.removePersonToMovieOccupation(personId, movieId, roleType);
    }

    @PostMapping("/person_fn/{person_fn}/person_ln/{person_ln}/movie_title/{movie_title}/role_type/{role_type}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addPersonToMovieOccupation(@PathVariable("person_fn") final String firstName,
                                           @PathVariable("person_ln") final String lastName,
                                           @PathVariable("movie_title") final String title,
                                           @PathVariable("role_type") final String roleType) {
        movieService.addPersonToMovieOccupation(firstName, lastName, title, roleType);
    }

    @DeleteMapping("/person_fn/{person_fn}/person_ln/{person_ln}/movie_title/{movie_title}/role_type/{role_type}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePersonToMovieOccupation(@PathVariable("person_fn") final String firstName,
                                              @PathVariable("person_ln") final String lastName,
                                              @PathVariable("movie_title") final String title,
                                              @PathVariable("role_type") final String roleType) {
        movieService.removePersonToMovieOccupation(firstName, lastName, title, roleType);
    }

    @Override
    protected BaseService<Movie, Long> getService() {
        return movieService;
    }
}
