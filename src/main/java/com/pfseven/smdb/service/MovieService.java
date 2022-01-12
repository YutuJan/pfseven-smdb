package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Genre;
import com.pfseven.smdb.domain.Movie;
import com.pfseven.smdb.domain.Occupation;
import com.pfseven.smdb.transfer.MoviesAndSeriesPerGenreDto;
import com.pfseven.smdb.transfer.MoviesPerGenrePerYearDto;
import com.pfseven.smdb.transfer.TopRatedMovieDto;

import java.util.List;

public interface MovieService extends BaseService<Movie, Long> {
    Movie get(String title);

    Movie find(String title);

    void deleteByTitle(String title);

    List<Movie> findMoviesByRatingIsGreaterThanEqual(Double rating);

    TopRatedMovieDto findTopRatedMovie();

    List<Movie> findMoviesByGenresContaining(Genre genre);

    List<MoviesAndSeriesPerGenreDto> findMoviesPerGenre();

    List<MoviesPerGenrePerYearDto> findMoviesPerGenrePerYear();

    void addOccupation(Movie movie, Occupation occupation);

    void removeOccupation(Movie movie, Occupation occupation);

    void addPersonToMovieOccupation(Long personId, Long movieId, String roleType);

    void addPersonToMovieOccupation(String firstName, String lastName, String title, String roleType);

    void removePersonToMovieOccupation(Long personId, Long movieId, String roleType);

    void removePersonToMovieOccupation(String firstName, String lastName, String title, String roleType);
}
