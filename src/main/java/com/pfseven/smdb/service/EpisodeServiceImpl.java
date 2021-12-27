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
    public void addOccupationToCastAndCrew(Episode episode, Occupation occupation) {
        if (isNull(occupation) || isNull(episode)) {
            return;
        }

        boolean occupationAlreadyExists = false;
        for (Occupation o : episode.getCastAndCrew()) {
            if (o.equals(occupation)) {
                occupationAlreadyExists = true;
                break;
            }
        }

        if (!occupationAlreadyExists) {
            episode.getCastAndCrew().add(occupation);
        }

        logger.debug("Occupation[{}] added to Episode[{}]", occupation, episode);
    }

    @Override
    public void removeOccupationToCastAndCrew(Episode episode, Occupation occupation) {
        if (isNull(occupation) || isNull(episode)) {
            return;
        }

        for (Occupation o : episode.getCastAndCrew()) {
            if (o.equals(occupation)) {
                episode.getCastAndCrew().remove(occupation);
                break;
            }
        }

        logger.debug("Occupation[{}] removed to Episode[{}]", occupation, episode);
    }

    @Override
    public void updateOccupationToCastAndCrew(Episode episode, Occupation occupation) {
        removeOccupationToCastAndCrew(episode, occupation);
        addOccupationToCastAndCrew(episode, occupation);

        logger.debug("Occupation[{}] updated to Episode[{}]", occupation, episode);
    }


    private boolean isNull(Object object) {
        if (object == null) {
            return true;
        }
        return false;
    }
}
