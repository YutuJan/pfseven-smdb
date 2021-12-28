package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Movie;
import com.pfseven.smdb.domain.Occupation;

public interface MovieService extends BaseService<Movie, Long> {
    Movie get(String title);

    Movie find(String title);

    void addOccupation(Movie movie, Occupation occupation);

    void removeOccupation(Movie movie, Occupation occupation);

    void updateOccupation(Movie movie, Occupation occupation);
}
