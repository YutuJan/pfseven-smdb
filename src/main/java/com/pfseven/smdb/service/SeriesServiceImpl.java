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
    private final EpisodeService episodeService;

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

        episode.setSeries(series);
        series.addEpisode(episode);
        episodeService.create(episode);

        logger.debug("Episode[{}] added to Series[{}]", episode, series);
    }

    @Override
    public void removeEpisode(Series series, Episode episode) {
        if (isNull(series) || isNull(episode)) {
            return;
        }

        episodeService.deleteOccupations(episode);
        series.removeEpisode(episode);
        update(series);

        logger.debug("Episode[{}] removed from Series[{}]", episode, series);
    }

    @Override
    public void updateEpisode(Series series, Episode episode) {
        series.updateEpisode(episode);
        episodeService.update(episode);

        logger.debug("Episode[{}] updated in Series[{}]", episode, series);
    }

    private boolean isNull(Object object) {
        return object == null;
    }
}
