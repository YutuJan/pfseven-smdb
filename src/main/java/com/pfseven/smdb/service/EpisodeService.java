package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Occupation;

public interface EpisodeService extends BaseService<Episode, Long> {
    Episode get(String title);

    Episode find(String title);

    void addOccupationToCastAndCrew(Episode episode, Occupation occupation);

    void removeOccupationToCastAndCrew(Episode episode, Occupation occupation);

    void updateOccupationToCastAndCrew(Episode episode, Occupation occupation);
}
