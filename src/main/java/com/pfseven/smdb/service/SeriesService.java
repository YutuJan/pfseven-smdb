package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Genre;
import com.pfseven.smdb.domain.Series;
import com.pfseven.smdb.transfer.MoviesAndSeriesPerGenreDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeriesService extends BaseService<Series, Long> {
    Series get(String title);

    Series find(String title);

    void deleteByTitle(String title);

    List<Series> findByGenre(Genre genre);

    @Query(nativeQuery = true)
    List<MoviesAndSeriesPerGenreDto> findSeriesPerGenre();

    void addEpisode(Series series, Episode episode);

    void updateEpisode(Series series, Episode episode);

    void removeEpisode(Series series, Episode episode);
}
