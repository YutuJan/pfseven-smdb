package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Occupation;
import com.pfseven.smdb.domain.Person;
import com.pfseven.smdb.domain.RoleType;
import com.pfseven.smdb.repository.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl extends BaseServiceImpl<Episode> implements EpisodeService {
    private final EpisodeRepository episodeRepository;
    private PersonService personService;

    @Autowired
    @Lazy
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

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
    public void addPersonToEpisodeOccupation(Long personId, Long episodeId, String roleType) {
        Person person = personService.find(personId);
        Episode episode = find(episodeId);
        Occupation occupation = Occupation.builder()
                .person(person)
                .videoEntertainment(episode)
                .occupation(RoleType.valueOf(roleType))
                .build();

        addOccupation(person, episode, occupation);
    }

    @Override
    public void addPersonToEpisodeOccupation(String firstName, String lastName, String title, String roleType) {
        Person person = personService.find(firstName, lastName);
        Episode episode = find(title);
        Occupation occupation = Occupation.builder()
                .person(person)
                .videoEntertainment(episode)
                .occupation(RoleType.valueOf(roleType))
                .build();

        addOccupation(person, episode, occupation);
    }

    @Override
    public void removePersonToEpisodeOccupation(Long personId, Long episodeId, String roleType) {
        Person person = personService.find(personId);
        Episode episode = find(episodeId);
        Occupation occupation = Occupation.builder()
                .person(person)
                .videoEntertainment(episode)
                .occupation(RoleType.valueOf(roleType))
                .build();

        removeOccupation(person, episode, occupation);
    }

    @Override
    public void removePersonToEpisodeOccupation(String firstName, String lastName, String title, String roleType) {
        Person person = personService.find(firstName, lastName);
        Episode episode = find(title);
        Occupation occupation = Occupation.builder()
                .person(person)
                .videoEntertainment(episode)
                .occupation(RoleType.valueOf(roleType))
                .build();

        removeOccupation(person, episode, occupation);
    }

    private void addOccupation(Person person, Episode episode, Occupation occupation) {
        personService.addOccupation(person, occupation);
        addOccupation(episode, occupation);
    }

    private void removeOccupation(Person person, Episode episode, Occupation occupation) {
        personService.removeOccupation(person, occupation);
        removeOccupation(episode, occupation);
    }

    private boolean isNull(Object object) {
        return object == null;
    }
}
