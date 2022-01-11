package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Occupation;

public interface EpisodeService extends BaseService<Episode, Long> {
    Episode get(String title);

    Episode find(String title);

    void deleteByTitle(String title);

    void deleteOccupations(Episode episode);

    void addOccupation(Episode episode, Occupation occupation);

    void removeOccupation(Episode episode, Occupation occupation);

    void addPersonToEpisodeOccupation(Long personId, Long episodeId, String roleType);

    void addPersonToEpisodeOccupation(String firstName, String lastName, String title, String roleType);

    void removePersonToEpisodeOccupation(Long personId, Long episodeId, String roleType);

    void removePersonToEpisodeOccupation(String firstName, String lastName, String title, String roleType);
}
