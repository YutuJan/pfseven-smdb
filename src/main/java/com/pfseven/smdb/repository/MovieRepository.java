package com.pfseven.smdb.repository;

import com.pfseven.smdb.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
