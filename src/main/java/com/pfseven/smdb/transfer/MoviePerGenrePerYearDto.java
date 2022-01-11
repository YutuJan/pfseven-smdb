package com.pfseven.smdb.transfer;

import com.pfseven.smdb.domain.Genre;

public interface MoviePerGenrePerYearDto {

    Long getYear();

    Genre getGenre();

    Long getCount();
}
