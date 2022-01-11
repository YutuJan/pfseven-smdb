package com.pfseven.smdb.transfer;

import com.pfseven.smdb.domain.Genre;

public interface MoviesPerGenrePerYearDto {

    Long getYear();

    Genre getGenre();

    Long getCount();
}
