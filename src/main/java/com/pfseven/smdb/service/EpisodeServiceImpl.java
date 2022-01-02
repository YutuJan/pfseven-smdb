package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Occupation;
import com.pfseven.smdb.domain.Series;
import com.pfseven.smdb.domain.SeriesCategory;
import com.pfseven.smdb.repository.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl extends BaseServiceImpl<Episode> implements EpisodeService {
    private final EpisodeRepository episodeRepository;

    public JpaRepository<Episode, Long> getRepository() {
        return episodeRepository;
    }

    @Override
    public Episode findByTitle(String title) {
        return episodeRepository.findEpisodeByTitle(title);
    }

    @Override
    public Episode findByDistributor(String distributor){

        return null;
    }

    @Override
    public void addPerson(Episode movie, Occupation occupation) {

    }

    @Override
    public void updatePerson(Episode movie, Occupation occupation) {

    }

    @Override
    public void removePerson(Episode movie, Occupation occupation) {

    }

    @Override
    public Episode findByDuration(Long duration) {
        return null;
    }

    @Override
    public Episode findByYear(Date date) {
        return null;
    }

    @Override
    public List<Episode> findBySeries(Series series) {
        return null;
    }


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
