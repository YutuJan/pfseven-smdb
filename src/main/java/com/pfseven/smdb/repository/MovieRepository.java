package com.pfseven.smdb.repository;

import com.pfseven.smdb.domain.Genre;
import com.pfseven.smdb.domain.Movie;
import com.pfseven.smdb.transfer.MoviesAndSeriesPerGenreDto;
import com.pfseven.smdb.transfer.MoviesPerGenrePerYearDto;
import com.pfseven.smdb.transfer.TopRatedMovieDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findMovieByTitle(String title);

    Movie getMovieByTitle(String title);

    List<Movie> findMoviesByGenresContaining(Genre genre);

    List<Movie> findMoviesByRatingIsGreaterThanEqual(Double rating);

    @Query(nativeQuery = true)
    List<MoviesAndSeriesPerGenreDto> findMoviesPerGenre();

    @Query(nativeQuery = true)
    List<MoviesPerGenrePerYearDto> findMoviesPerGenrePerYear();

    @Query(nativeQuery = true)
    TopRatedMovieDto findTopRatedMovie();
}
