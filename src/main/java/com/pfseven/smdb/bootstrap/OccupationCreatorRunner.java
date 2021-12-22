package com.pfseven.smdb.bootstrap;

import com.pfseven.smdb.base.AbstractLogComponent;
import com.pfseven.smdb.domain.Occupation;
import com.pfseven.smdb.service.OccupationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class OccupationCreatorRunner extends AbstractLogComponent implements CommandLineRunner {
    private final OccupationService occupationService;

    @Override
    public void run(String... args) throws Exception {

    }
}
