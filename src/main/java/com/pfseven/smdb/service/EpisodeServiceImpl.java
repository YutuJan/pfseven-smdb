package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Occupation;
import com.pfseven.smdb.repository.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl extends BaseServiceImpl<Episode> implements EpisodeService {
    private final EpisodeRepository episodeRepository;

    @Override
    public Episode get(String title) {
        return null;
    }

    @Override
    public Episode find(String title) {
        return null;
    }

    @Override
    public void newCastAndCrew(Episode episode, Occupation occupation) {

    }

    @Override
    public void removeCastAndCrew(Episode episode, Occupation occupation) {

    }

    JpaRepository<Episode, Long> getRepository() {
        return episodeRepository;
    }
}
