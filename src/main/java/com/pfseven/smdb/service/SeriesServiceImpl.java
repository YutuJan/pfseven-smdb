package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Series;
import com.pfseven.smdb.repository.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeriesServiceImpl extends BaseServiceImpl<Series> implements SeriesService {
    private final SeriesRepository seriesRepository;

    JpaRepository<Series, Long> getRepository() {
        return seriesRepository;
    }

    @Override
    public Series get(String title) {
        return seriesRepository.getByTitle(title);
    }

    @Override
    public Series find(String title) {
        return seriesRepository.findByTitle(title);
    }

    @Override
    public void addEpisode(Series series, Episode episode) {
        if (isNull(series) || isNull(episode)) {
            return;
        }

        boolean episodeAlreadyExists = false;
        for (Episode e : series.getEpisodes()) {
            if (series.getTitle().equals(e.getTitle())) {
                episodeAlreadyExists = true;
                break;
            }
        }

        if (!episodeAlreadyExists) {
            series.getEpisodes().add(episode);
        }

        logger.debug("Episode[{}] added to Series[{}]", episode, series);
    }

    @Override
    public void removeEpisode(Series series, Episode episode) {
        if (isNull(series) || isNull(episode)) {
            return;
        }

        for (Episode e : series.getEpisodes()) {
            if (e.getTitle().equals(episode.getTitle())) {
                series.getEpisodes().remove(e);
                break;
            }
        }

        logger.debug("Episode[{}] removed to Series[{}]", episode, series);
    }

    @Override
    public void updateEpisode(Series series, Episode episode) {
        removeEpisode(series, episode);
        addEpisode(series, episode);

        logger.debug("Episode[{}] updated to Series[{}]", episode, series);
    }

    private boolean isNull(Object object) {
        if (object == null) {
            return true;
        }
        return false;
    }
}
