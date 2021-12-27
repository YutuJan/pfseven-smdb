package com.pfseven.smdb.bootstrap;

import com.pfseven.smdb.base.AbstractLogComponent;
import com.pfseven.smdb.service.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class SeriesCreatorRunner extends AbstractLogComponent implements CommandLineRunner {
    private SeriesService seriesService;

    private final String SUMMARY_000 = "A notorious hacker takes an interest in cyber security engineer and vigilante" +
            " styled computer hacker Elliot, while an evil corporation is hacked.";
    private final String SUMMARY_001 = "Elliot is hesitant about fsociety; Elliot is offered a new job; Elliot" +
            " worries about Shayla's association with Fernando Vera; Ollie is given a CD outside of Allsafe; Mr." +
            " Robot makes Elliot talk about his father.";
    private final String SUMMARY_002 = "Monica and the gang introduce Rachel to the \"real world\" after she leaves" +
            " her fiancé at the altar.";
    private final String SUMMARY_003 = "Ross finds out his ex-wife is pregnant. Rachel returns her engagement ring to" +
            " Barry. Monica becomes stressed when her and Ross's parents come to visit.";

    private final String TITLE_001 = "Mr. Robot";
    private final String TITLE_002 = "Friends";

    @Override
    public void run(String... args) throws Exception {
        createBunchOfTvShowEpisodes();
    }

    private void createBunchOfTvShowEpisodes(){

    }
}
