package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Series;

public interface SeriesService extends BaseService<Series, Long> {
    Series get(String title);

    Series find(String title);

    void deleteByTitle(String title);

    void addEpisode(Series series, Episode episode);

    void updateEpisode(Series series, Episode episode);

    void removeEpisode(Series series, Episode episode);
}
