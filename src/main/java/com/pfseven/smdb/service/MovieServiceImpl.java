package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Movie;
import com.pfseven.smdb.domain.Occupation;
import com.pfseven.smdb.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public Movie get(String title) {
        return null;
    }

    @Override
    public Movie find(String title) {
        return null;
    }

    @Override
    public void newCastAndCrew(Movie movie, Occupation occupation) {

    }

    @Override
    public void removeCastAndCrew(Movie movie, Occupation occupation) {

    }

    JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }
}
