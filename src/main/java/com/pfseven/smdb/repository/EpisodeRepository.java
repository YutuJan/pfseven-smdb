package com.pfseven.smdb.repository;

import com.pfseven.smdb.domain.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long>  {
    Episode findEpisodeByTitle(String title);

    Episode getEpisodeByTitle(String title);
}
