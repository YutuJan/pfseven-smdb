package com.pfseven.smdb.repository;

import com.pfseven.smdb.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
