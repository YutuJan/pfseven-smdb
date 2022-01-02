package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Genre;
import com.pfseven.smdb.domain.Movie;
import com.pfseven.smdb.domain.Occupation;

import java.time.LocalDate;
import java.util.Date;

public interface MovieService extends BaseService<Movie, Long> {

    Movie findByTitle(String title);

    Movie findByDistributor(String distributor);

    void addPerson(Movie movie, Occupation occupation);

    void updatePerson(Movie movie, Occupation occupation);

    void removePerson(Movie movie, Occupation occupation);

    Movie findByDuration(Long duration);

    Movie findByYear(LocalDate date);

    Movie findByGenre(Genre genre);
}
