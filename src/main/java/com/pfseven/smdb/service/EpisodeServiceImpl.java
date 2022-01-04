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

    JpaRepository<Episode, Long> getRepository() {
        return episodeRepository;
    }

    @Override
    public Episode get(String title) {
        return episodeRepository.getEpisodeByTitle(title);
    }

    @Override
    public Episode find(String title) {
        return episodeRepository.findEpisodeByTitle(title);
    }

    @Override
    public void addOccupation(Episode episode, Occupation occupation) {
        if (isNull(occupation) || isNull(episode)) {
            return;
        }

        episode.addOccupation(occupation);
        update(episode);

        logger.debug("Occupation[{}] added to Episode[{}]", occupation, episode);
    }

    @Override
    public void removeOccupation(Episode episode, Occupation occupation) {
        if (isNull(occupation) || isNull(episode)) {
            return;
        }

        episode.removeOccupation(occupation);
        update(episode);

        logger.debug("Occupation[{}] removed to Episode[{}]", occupation, episode);
    }

    @Override
    public void updateOccupation(Episode episode, Occupation occupation) {
        if (isNull(occupation) || isNull(episode)) {
            return;
        }

        episode.updateOccupation(occupation);

        logger.debug("Occupation[{}] updated to Episode[{}]", occupation, episode);
    }

    private boolean isNull(Object object) {
        return object == null;
    }
}
