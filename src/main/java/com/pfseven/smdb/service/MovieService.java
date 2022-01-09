package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Genre;
import com.pfseven.smdb.domain.Movie;
import com.pfseven.smdb.domain.Occupation;
import com.pfseven.smdb.transfer.TopRatedMovieDto;

import java.util.List;

public interface MovieService extends BaseService<Movie, Long> {
    Movie get(String title);

    Movie find(String title);

    List<Movie> findMoviesByRatingIsGreaterThanEqual(Double rating);

    TopRatedMovieDto findTopRatedMovie();

    List<Movie> findMoviesByGenresContaining(Genre genre);

    void addOccupation(Movie movie, Occupation occupation);

    void removeOccupation(Movie movie, Occupation occupation);

    void updateOccupation(Movie movie, Occupation occupation);
}
