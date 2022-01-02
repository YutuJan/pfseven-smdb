package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Genre;
import com.pfseven.smdb.domain.Movie;
import com.pfseven.smdb.domain.Occupation;
import com.pfseven.smdb.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
    private final MovieRepository movieRepository;

    public JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }

    @Override
    public Movie findByTitle(String title) {
        return null;
    }

    @Override
    public Movie findByDistributor(String distributor){
        return null;
    }

    @Override
    public void addPerson(Movie movie, Occupation occupation) {

    }

    @Override
    public void updatePerson(Movie movie, Occupation occupation) {

    }

    @Override
    public void removePerson(Movie movie, Occupation occupation) {

    }

    @Override
    public Movie findByDuration(Long duration) {
        return null;
    }

    @Override
    public Movie findByYear(LocalDate date) {
        return null;
    }

    @Override
    public Movie findByGenre(Genre genre) {
        return null;
    }
}
