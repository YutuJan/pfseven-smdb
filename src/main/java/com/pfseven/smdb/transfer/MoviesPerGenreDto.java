package com.pfseven.smdb.transfer;

import com.pfseven.smdb.domain.Genre;

public interface MoviesPerGenreDto {

    Genre getGenre();

    Long getCount();
}
