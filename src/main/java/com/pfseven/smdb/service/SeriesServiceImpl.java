package com.pfseven.smdb.service;

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
    public void newSeason(Series series, Season season) {

    }

    @Override
    public void removeSeason(Series series, Season season) {

    }

    JpaRepository<Series, Long> getRepository() {return seriesRepository;}
}
