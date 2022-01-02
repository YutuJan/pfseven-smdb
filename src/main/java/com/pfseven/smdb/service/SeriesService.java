package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Series;
import com.pfseven.smdb.domain.SeriesCategory;

import java.util.List;

public interface SeriesService extends BaseService<Series, Long> {

    Series findByTitle(String title);

    void addEpisode(Series series, Episode episode);

    void updateEpisode(Series series, Episode episode);

    void removeEpisode(Series series, Episode episode);

    Series findByCategory(SeriesCategory category);
}
