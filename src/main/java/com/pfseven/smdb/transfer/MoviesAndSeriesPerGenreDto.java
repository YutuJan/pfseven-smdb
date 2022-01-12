package com.pfseven.smdb.transfer;

import com.pfseven.smdb.domain.Genre;

public interface MoviesAndSeriesPerGenreDto {

    Genre getGenre();

    Long getCount();
}
