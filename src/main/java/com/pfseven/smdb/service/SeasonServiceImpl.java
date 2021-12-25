package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeasonServiceImpl extends BaseServiceImpl<Season> implements SeasonService {
    private final SeasonRepository seasonRepository;

    @Override
    public Season get(String title) {
        return null;
    }

    @Override
    public Season find(String title) {
        return null;
    }

    @Override
    public void newEpisode(Season season, Episode episode) {

    }

    @Override
    public void removeEpisode(Season season, Episode episode) {

    }

    JpaRepository<Season, Long> getRepository() {
        return seasonRepository;
    }
}
