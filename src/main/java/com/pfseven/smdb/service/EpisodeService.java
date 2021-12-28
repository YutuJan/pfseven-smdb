package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Occupation;

public interface EpisodeService extends BaseService<Episode, Long> {
    Episode get(String title);

    Episode find(String title);

    void addOccupation(Episode episode, Occupation occupation);

    void removeOccupation(Episode episode, Occupation occupation);

    void updateOccupation(Episode episode, Occupation occupation);
}
