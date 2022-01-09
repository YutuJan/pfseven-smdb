package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Genre;
import com.pfseven.smdb.domain.Movie;
import com.pfseven.smdb.domain.Occupation;
import com.pfseven.smdb.repository.MovieRepository;
import com.pfseven.smdb.transfer.TopRatedMovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
    private final MovieRepository movieRepository;

    JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }

    @Override
    public Movie get(String title) {
        return movieRepository.getMovieByTitle(title);
    }

    @Override
    public Movie find(String title) {
        return movieRepository.findMovieByTitle(title);
    }

    @Override
    public List<Movie> findMoviesByRatingIsGreaterThanEqual(Double rating) {
        return movieRepository.findMoviesByRatingIsGreaterThanEqual(rating);
    }

    @Override
    public TopRatedMovieDto findTopRatedMovie() {
        return movieRepository.findTopRatedMovie();
    }

    @Override
    public List<Movie> findMoviesByGenresContaining(Genre genre) {
        return movieRepository.findMoviesByGenresContaining(genre);
    }

    @Override
    public void addOccupation(Movie movie, Occupation occupation) {
        if (isNull(occupation) || isNull(movie)) {
            return;
        }

        movie.addOccupation(occupation);
        update(movie);

        logger.debug("Occupation[{}] added to Movie[{}]", occupation, movie);
    }

    @Override
    public void removeOccupation(Movie movie, Occupation occupation) {
        if (isNull(occupation) || isNull(movie)) {
            return;
        }

        movie.removeOccupation(occupation);
        update(movie);

        logger.debug("Occupation[{}] removed to Movie[{}]", occupation, movie);
    }

    @Override
    public void updateOccupation(Movie movie, Occupation occupation) {
        if (isNull(occupation) || isNull(movie)) {
            return;
        }

        movie.updateOccupation(occupation);

        logger.debug("Occupation[{}] updated to Movie[{}]", occupation, movie);
    }

    private boolean isNull(Object object) {
        return object == null;
    }
}
