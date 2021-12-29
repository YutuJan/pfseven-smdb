package com.pfseven.smdb.bootstrap;

import com.pfseven.smdb.base.AbstractLogComponent;
import com.pfseven.smdb.domain.*;
import com.pfseven.smdb.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class OccupationCreatorRunner extends AbstractLogComponent implements CommandLineRunner {
    private final OccupationService occupationService;
    private final PersonService personService;
    private final MovieService movieService;
    private final EpisodeService episodeService;

    @Override
    public void run(String... args) throws Exception {
    }

    public void createBunchOfOccupations() {
        Person person1 = personService.get("Jackie", "Chan");
        Person person2 = personService.get("Chris", "Tucker");
        Person person3 = personService.get("Anthony", "Quinn");
        Person person4 = personService.get("Keanu", "Reeves");
        Person person5 = personService.get("Carrie-Anne", "Moss");
        Person person6 = personService.get("Laurence", "Fishburne");
        Person person7 = personService.get("Arnold", "Schwarzenegger");
        Person person8 = personService.get("Linda", "Hamilton");
        Person person9 = personService.get("Milla", "Jovovich");
        Person person10 = personService.get("Bruce", "Willis");
        Person person11 = personService.get("Sylvester", "Stallone");
        Person person12 = personService.get("Dolph", "Lundgren");
        Person person13 = personService.get("Jeff", "Bridges");
        Person person14 = personService.get("Julianne", "Moore");
        Person person15 = personService.get("Rami", "Malek");
        Person person16 = personService.get("Jennifer", "Aniston");
        Person person17 = personService.get("Courteney", "Cox");
        Person person18 = personService.get("Jim", "Carrey");
        Person person19 = personService.get("Jeff", "Daniels");
        Person person20 = personService.get("Lucy", "Boynton");

        Movie movie1 = movieService.get("The Matrix");
        Movie movie2 = movieService.get("Zorba the Greek");
        Movie movie3 = movieService.get("Rush Hour");
        Movie movie4 = movieService.get("The Terminator");
        Movie movie5 = movieService.get("The Expendables");
        Movie movie6 = movieService.get("Rocky");
        Movie movie7 = movieService.get("The Big Lebowski");
        Movie movie8 = movieService.get("Ace Ventura: Pet Detective");
        Movie movie9 = movieService.get("Dumb & Dumber");
        Movie movie10 = movieService.get("Bohemian Rhapsody");

        Episode episode1 = episodeService.get("eps1.0_hellofriend.mov");
        Episode episode2 = episodeService.get("eps1.1_ones-and-zer0es.mpeg");
        Episode episode3 = episodeService.get("The One Where Monica Gets a Roommate");
        Episode episode4 = episodeService.get("The One with the Sonogram at the End");

        List<Occupation> occupationsInMovies = List.of(
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person1)
                        .videoEntertainment(movie3)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person2)
                        .videoEntertainment(movie3)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person3)
                        .videoEntertainment(movie2)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person4)
                        .videoEntertainment(movie1)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person5)
                        .videoEntertainment(movie1)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person6)
                        .videoEntertainment(movie1)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person7)
                        .videoEntertainment(movie4)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person8)
                        .videoEntertainment(movie4)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person1)
                        .videoEntertainment(movie5)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person7)
                        .videoEntertainment(movie5)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person9)
                        .videoEntertainment(movie5)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person10)
                        .videoEntertainment(movie5)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person11)
                        .videoEntertainment(movie5)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person12)
                        .videoEntertainment(movie5)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person13)
                        .videoEntertainment(movie7)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person14)
                        .videoEntertainment(movie7)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person15)
                        .videoEntertainment(movie10)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person20)
                        .videoEntertainment(movie10)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person18)
                        .videoEntertainment(movie9)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person19)
                        .videoEntertainment(movie9)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person11)
                        .videoEntertainment(movie6)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person12)
                        .videoEntertainment(movie6)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person18)
                        .videoEntertainment(movie8)
                        .build()
        );

        List<Occupation> occupationsInEpisodes = List.of(
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person15)
                        .videoEntertainment(episode1)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person15)
                        .videoEntertainment(episode2)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person16)
                        .videoEntertainment(episode3)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person17)
                        .videoEntertainment(episode3)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person16)
                        .videoEntertainment(episode4)
                        .build(),
                Occupation.builder()
                        .occupation(RoleType.ACTOR)
                        .person(person17)
                        .videoEntertainment(episode4)
                        .build()
        );

        logger.info("Created {} occupations in movies.", occupationService.createAll(occupationsInMovies).size());
        logger.info("Created {} occupations in episodes.", occupationService.createAll(occupationsInEpisodes).size());
    }
}
