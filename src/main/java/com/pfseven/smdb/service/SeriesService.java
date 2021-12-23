package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Season;
import com.pfseven.smdb.domain.Series;

public interface SeriesService extends BaseService<Series, Long> {
    Series get(String title);

    Series find(String title);

    void addSeason(Series series, Season season);

    void removeSeason(Series series, Season season);

    void addEpisode(Season season, Episode episode);

    void removeEpisode(Season season, Episode episode);
}
