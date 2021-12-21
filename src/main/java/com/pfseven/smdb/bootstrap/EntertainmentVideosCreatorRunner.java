package com.pfseven.smdb.bootstrap;

import com.pfseven.smdb.base.AbstractLogComponent;
import com.pfseven.smdb.domain.Genre;
import com.pfseven.smdb.domain.VideoEntertainment;
import com.pfseven.smdb.domain.VideoEntertainmentCategory;
import com.pfseven.smdb.service.VideoEntertainmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class EntertainmentVideosCreatorRunner extends AbstractLogComponent implements CommandLineRunner {
    private final VideoEntertainmentService videoEntertainmentService;

    private final String SUMMARY_000 = "Neo (Keanu Reeves) believes that Morpheus (Laurence Fishburne), an elusive" +
            " figure considered to be the most dangerous man alive, can answer his question -- What is the Matrix?" +
            " Neo is contacted by Trinity (Carrie-Anne Moss), a beautiful stranger who leads him into an underworld" +
            " where he meets Morpheus. They fight a brutal battle for their lives against a cadre of viciously" +
            " intelligent secret agents. It is a truth that could cost Neo something more precious than his life.";
    private final String SUMMARY_001 = "Traveling to inspect an abandoned mine his father owns in Crete, English" +
            " author Basil (Alan Bates) meets the exuberant peasant Zorba (Anthony Quinn) and invites him along when" +
            " the older man claims he has mining experience. In Basil's father's old village, he finds himself" +
            " attracted to a young widow (Irene Papas), and Zorba takes up with the woman who runs their hotel" +
            " (Lila Kedrova). When things go wrong, Zorba teaches Basil how to enjoy life even under the most" +
            " trying circumstances.";
    private final String SUMMARY_002 = "When a Chinese diplomat's daughter is kidnapped in Los Angeles, he calls in" +
            " Hong Kong Detective Inspector Lee (Jackie Chan) to assist the FBI with the case. But the FBI doesn't" +
            " want anything to do with Lee, and they dump him off on the LAPD, who assign wisecracking Detective" +
            " James Carter (Chris Tucker) to watch over him. Although Lee and Carter can't stand each other, they" +
            " choose to work together to solve the case on their own when they figure out they've been ditched by" +
            " both the FBI and police.";
    private final String SUMMARY_003 = "Disguised as a human, a cyborg assassin known as a Terminator (Arnold" +
            " Schwarzenegger) travels from 2029 to 1984 to kill Sarah Connor (Linda Hamilton). Sent to protect" +
            " Sarah is Kyle Reese (Michael Biehn), who divulges the coming of Skynet, an artificial intelligence" +
            " system that will spark a nuclear holocaust. Sarah is targeted because Skynet knows that her unborn" +
            " son will lead the fight against them. With the virtually unstoppable Terminator in hot pursuit, she" +
            " and Kyle attempt to escape.";
    private final String SUMMARY_004 = "Mercenary leader Barney Ross (Sylvester Stallone) and his loyal men take on" +
            " what they think is a routine assignment: a covert operation to invade the South American country of" +
            " Vilena and overthrow its dictator. But, when they learn that the job will be a suicide mission, they" +
            " must choose redemption or the destruction of their brotherhood.";
    private final String SUMMARY_005 = "Rocky Balboa (Sylvester Stallone), a small-time boxer from working-class" +
            " Philadelphia, is arbitrarily chosen to take on the reigning world heavyweight champion, Apollo Creed" +
            " (Carl Weathers), when the undefeated fighter's scheduled opponent is injured. While training with" +
            " feisty former bantamweight contender Mickey Goldmill (Burgess Meredith), Rocky tentatively begins" +
            " a relationship with Adrian (Talia Shire), the wallflower sister of his meat-packer pal Paulie (Burt" +
            " Young).";
    private final String SUMMARY_006 = "Jeff Bridges plays Jeff Lebowski who insists on being called \"the Dude,\"" +
            " a laid-back, easygoing burnout who happens to have the same name as a millionaire whose wife owes a" +
            " lot of dangerous people a whole bunch of money -- resulting in the Dude having his rug soiled, sending" +
            " him spiraling into the Los Angeles underworld.";
    private final String SUMMARY_007 = "When the dolphin mascot of Miami's NFL team is abducted, Ace Ventura (Jim" +
            " Carrey), a zany private investigator who specializes in finding missing animals, looks into the case." +
            " Soon Miami Dolphins players are kidnapped too, including star player Dan Marino (Dan Marino), making" +
            " Ace's sleuth work even more pressing. Working with Dolphins representative Melissa Robinson" +
            " (Courteney Cox), Ace closes in on the culprits, but not before many ridiculous misadventures.";
    private final String SUMMARY_008 = "Imbecilic best friends Lloyd Christmas (Jim Carrey) and Harry Dunne (Jeff" +
            " Daniels) stumble across a suitcase full of money left behind in Harry's car by Mary Swanson (Lauren" +
            " Holly), who was on her way to the airport. The pair decide to go to Aspen, Colo., to return the" +
            " money, unaware that it is connected to a kidnapping. As Harry and Lloyd -- who has fallen in love" +
            " with Mary -- are pursued across the country by hired killers and police, they find both their" +
            " friendship and their brains tested.";
    private final String SUMMARY_009 = "Freddie Mercury -- the lead singer of Queen -- defies stereotypes and" +
            " convention to become one of history's most beloved entertainers. The band's revolutionary sound and" +
            " popular songs lead to Queen's meteoric rise in the 1970s. After leaving the group to pursue a solo" +
            " career, Mercury reunites with Queen for the benefit concert Live Aid -- resulting in one of the" +
            " greatest performances in rock 'n' roll history. ";
    private final String SUMMARY_010 = "A notorious hacker takes an interest in cyber security engineer and vigilante" +
            " styled computer hacker Elliot, while an evil corporation is hacked.";
    private final String SUMMARY_011 = "Elliot is hesitant about fsociety; Elliot is offered a new job; Elliot" +
            " worries about Shayla's association with Fernando Vera; Ollie is given a CD outside of Allsafe; Mr." +
            " Robot makes Elliot talk about his father.";
    private final String SUMMARY_012 = "Monica and the gang introduce Rachel to the \"real world\" after she leaves" +
            " her fiancé at the altar.";
    private final String SUMMARY_013 = "Ross finds out his ex-wife is pregnant. Rachel returns her engagement ring to" +
            " Barry. Monica becomes stressed when her and Ross's parents come to visit.";

    @Override
    public void run(String... args) throws Exception {
        createBunchOfFilms();
        createBunchOfTvShowEpisodes();
    }

    private void createBunchOfFilms() {
        List<VideoEntertainment> videoEntertainments = List.of(
                VideoEntertainment.builder()
                        .title("The Matrix")
                        .summary(SUMMARY_000)
                        .durationInSeconds(8160)
                        .releaseDate(LocalDate.of(1999, 3, 31))
                        .distributor("Warner Bros. Pictures")
                        .videoEntertainmentCategory(VideoEntertainmentCategory.FILM)
                        .rating(8.7)
                        .genres(Set.of(Genre.ACTION, Genre.SCI_FI))
                        .build(),
                VideoEntertainment.builder()
                        .title("Zorba the Greek")
                        .summary(SUMMARY_001)
                        .durationInSeconds(8520)
                        .releaseDate(LocalDate.of(1964, 12, 14))
                        .distributor("Michael Cacoyannis") //TODO may not be accurate
                        .videoEntertainmentCategory(VideoEntertainmentCategory.FILM)
                        .rating(7.7)
                        .genres(Set.of(Genre.DRAMA))
                        .build(),
                VideoEntertainment.builder()
                        .title("Rush Hour")
                        .summary(SUMMARY_002)
                        .durationInSeconds(5880)
                        .releaseDate(LocalDate.of(2007, 5, 22))
                        .distributor("New Line Cinema")
                        .videoEntertainmentCategory(VideoEntertainmentCategory.FILM)
                        .rating(7.0)
                        .genres(Set.of(Genre.ACTION, Genre.COMEDY, Genre.SPORTS_AND_FITNESS))
                        .build(),
                VideoEntertainment.builder()
                        .title("The Terminator")
                        .summary(SUMMARY_003)
                        .durationInSeconds(6480)
                        .releaseDate(LocalDate.of(2001, 10, 2))
                        .distributor("Orion Pictures")
                        .videoEntertainmentCategory(VideoEntertainmentCategory.FILM)
                        .rating(7.6)
                        .genres(Set.of(Genre.ACTION, Genre.MYSTERY, Genre.THRILLER, Genre.SCI_FI))
                        .build(),
                VideoEntertainment.builder()
                        .title("The Expendables")
                        .summary(SUMMARY_004)
                        .durationInSeconds(6180)
                        .releaseDate(LocalDate.of(2010, 8, 13))
                        .distributor("Lionsgate Films")
                        .videoEntertainmentCategory(VideoEntertainmentCategory.FILM)
                        .rating(6.5)
                        .genres(Set.of(Genre.ACTION, Genre.ADVENTURE))
                        .build(),
                VideoEntertainment.builder()
                        .title("Rocky")
                        .summary(SUMMARY_005)
                        .durationInSeconds(7140)
                        .releaseDate(LocalDate.of(1976, 12, 1))
                        .distributor("United Artists")
                        .videoEntertainmentCategory(VideoEntertainmentCategory.FILM)
                        .rating(8.1)
                        .genres(Set.of(Genre.DRAMA))
                        .build(),
                VideoEntertainment.builder()
                        .title("The Big Lebowski")
                        .summary(SUMMARY_006)
                        .durationInSeconds(7020)
                        .releaseDate(LocalDate.of(1998, 3, 6))
                        .distributor("Gramercy Pictures")
                        .videoEntertainmentCategory(VideoEntertainmentCategory.FILM)
                        .rating(8.1)
                        .genres(Set.of(Genre.COMEDY))
                        .build(),
                VideoEntertainment.builder()
                        .title("Ace Ventura: Pet Detective")
                        .summary(SUMMARY_007)
                        .durationInSeconds(5160)
                        .releaseDate(LocalDate.of(1994, 2, 4))
                        .distributor("Argentina Video Home, Warner Bros.")
                        .videoEntertainmentCategory(VideoEntertainmentCategory.FILM)
                        .rating(6.9)
                        .genres(Set.of(Genre.COMEDY))
                        .build(),
                VideoEntertainment.builder()
                        .title("Dumb & Dumber")
                        .summary(SUMMARY_008)
                        .durationInSeconds(6360)
                        .releaseDate(LocalDate.of(2001, 10, 2))
                        .distributor("New Line Cinema")
                        .videoEntertainmentCategory(VideoEntertainmentCategory.FILM)
                        .rating(7.3)
                        .genres(Set.of(Genre.COMEDY))
                        .build(),
                VideoEntertainment.builder()
                        .title("Bohemian Rhapsody")
                        .summary(SUMMARY_009)
                        .durationInSeconds(8100)
                        .releaseDate(LocalDate.of(2018, 11, 2))
                        .distributor("20th Century Studios")
                        .videoEntertainmentCategory(VideoEntertainmentCategory.FILM)
                        .rating(7.9)
                        .genres(Set.of(Genre.DRAMA, Genre.LGBTQ, Genre.HISTORY, Genre.BIOGRAPHY, Genre.MUSIC))
                        .build()
        );

        logger.info("Created {} products.", videoEntertainmentService.createAll(videoEntertainments).size());
    }

    private void createBunchOfTvShowEpisodes(){
        List<VideoEntertainment> videoEntertainments = List.of(
                VideoEntertainment.builder()
                        .title("Mr. Robot: Season 1: HelloFriend")
                        .summary(SUMMARY_010)
                        .durationInSeconds(3720)
                        .releaseDate(LocalDate.of(2015, 6, 24))
                        .distributor("NBCUniversal Television Distribution")
                        .videoEntertainmentCategory(VideoEntertainmentCategory.TV_SHOW_EPISODE)
                        .rating(9.3)
                        .genres(Set.of(Genre.DRAMA, Genre.MYSTERY, Genre.THRILLER, Genre.CRIME))
                        .build(),
                VideoEntertainment.builder()
                        .title("Mr. Robot: Season 1: ones-and-zer0es")
                        .summary(SUMMARY_011)
                        .durationInSeconds(2880)
                        .releaseDate(LocalDate.of(2015, 7, 1))
                        .distributor("NBCUniversal Television Distribution")
                        .videoEntertainmentCategory(VideoEntertainmentCategory.TV_SHOW_EPISODE)
                        .rating(8.6)
                        .genres(Set.of(Genre.DRAMA, Genre.MYSTERY, Genre.THRILLER, Genre.CRIME))
                        .build(),
                VideoEntertainment.builder()
                        .title("Friends: Season 1: The One Where Monica Gets a Roommate")
                        .summary(SUMMARY_012)
                        .durationInSeconds(1320)
                        .releaseDate(LocalDate.of(1994, 9, 22))
                        .distributor("National Broadcasting Company (NBC)")
                        .videoEntertainmentCategory(VideoEntertainmentCategory.TV_SHOW_EPISODE)
                        .rating(8.3)
                        .genres(Set.of(Genre.COMEDY))
                        .build(),
                VideoEntertainment.builder()
                        .title("Friends: Season 1: The One With the Sonogram at the End")
                        .summary(SUMMARY_013)
                        .durationInSeconds(1320)
                        .releaseDate(LocalDate.of(1994, 9, 29))
                        .distributor("National Broadcasting Company (NBC)")
                        .videoEntertainmentCategory(VideoEntertainmentCategory.TV_SHOW_EPISODE)
                        .rating(8.0)
                        .genres(Set.of(Genre.COMEDY))
                        .build()
        );

        logger.info("Created {} products.", videoEntertainmentService.createAll(videoEntertainments).size());
    }
}
