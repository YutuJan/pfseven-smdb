package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Season;
import com.pfseven.smdb.domain.Series;
import com.pfseven.smdb.repository.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeriesServiceImpl extends BaseServiceImpl<Series> implements SeriesService {
    private final SeriesRepository seriesRepository;

    @Override
    public Series get(String title) {
        return null;
    }

    @Override
    public Series find(String title) {
        return null;
    }

    @Override
    public void addSeason(Series series, Season season) {
        if (isNull(series) || isNull(season)) {
            return;
        }

        boolean seasonAlreadyExists = false;
        for (Season s : series.getSeasons()) {
            if (s.getNumber().equals(season.getNumber())) {
                seasonAlreadyExists = true;
                break;
            }
        }

        if (!seasonAlreadyExists) {
            series.getSeasons().add(season);
            season.setSeries(series);
        }

        logger.debug("Season[{}] added to Series[{}]", season, series);
    }

    @Override
    public void removeSeason(Series series, Season season) {
        if (isNull(series) || isNull(season)) {
            return;
        }

        for (Season s : series.getSeasons()) {
            if (s.getNumber().equals(season.getNumber())) {
                series.getSeasons().remove(s);
                break;
            }
        }

        logger.debug("Season[{}] removed from Series[{}]", season, series);
    }

    @Override
    public void addEpisode(Season season, Episode episode) {
        if (isNull(episode) || isNull(season)) {
            return;
        }

        boolean episodeAlreadyExists = false;
        for (Episode e : season.getEpisodes()) {
            if (e.getTitle().equals(episode.getTitle())) {
                episodeAlreadyExists = true;
                break;
            }
        }

        if (!episodeAlreadyExists) {
            season.getEpisodes().add(episode);
            episode.setSeason(season);
        }

        logger.debug("Episode[{}] added to Season[{}]", episode, season);
    }

    @Override
    public void removeEpisode(Season season, Episode episode) {
        if (isNull(episode) || isNull(season)) {
            return;
        }

        for (Episode e : season.getEpisodes()) {
            if (e.getTitle().equals(episode.getTitle())) {
                season.getEpisodes().remove(e);
                break;
            }
        }

        logger.debug("Episode[{}] added to Season[{}]", episode, season);
    }

    JpaRepository<Series, Long> getRepository() {
        return seriesRepository;
    }

    private boolean isNull(Object object) {
        if (object == null) {
            return true;
        }
        return false;
    }
}
