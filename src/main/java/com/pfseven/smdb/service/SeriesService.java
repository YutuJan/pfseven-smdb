package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Season;
import com.pfseven.smdb.domain.Series;

public interface SeriesService extends BaseService<Series, Long> {
    Series get(String title);

    Series find(String title);

    void newSeason(Series series, Season season);

    void removeSeason(Series series, Season season);
}
