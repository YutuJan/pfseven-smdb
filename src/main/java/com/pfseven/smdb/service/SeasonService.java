package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Season;

public interface SeasonService extends BaseService<Season, Long> {
    Season get(String title);

    Season find(String title);

    void newEpisode(Season season, Episode episode);

    void removeEpisode(Season season, Episode episode);
}