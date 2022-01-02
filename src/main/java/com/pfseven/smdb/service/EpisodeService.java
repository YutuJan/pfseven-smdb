package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.*;

import java.util.Date;
import java.util.List;

public interface EpisodeService extends BaseService<Episode, Long> {

    Episode findByTitle(String title);

    Episode findByDistributor(String distributor);

    void addPerson(Episode movie, Occupation occupation);

    void updatePerson(Episode movie, Occupation occupation);

    void removePerson(Episode movie, Occupation occupation);

    Episode findByDuration(Long duration);

    Episode findByYear(Date date);

    List<Episode> findBySeries(Series series);
}
