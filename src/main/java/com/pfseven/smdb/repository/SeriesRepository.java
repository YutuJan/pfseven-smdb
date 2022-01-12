package com.pfseven.smdb.repository;

import com.pfseven.smdb.domain.Genre;
import com.pfseven.smdb.domain.Series;
import com.pfseven.smdb.transfer.MoviesAndSeriesPerGenreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    Series findByTitle(String title);

    Series getByTitle(String title);

    List<Series> findSeriesByGenresContaining(Genre genre);

    @Query(nativeQuery = true)
    List<MoviesAndSeriesPerGenreDto> findSeriesPerGenre();

}
