package com.pfseven.smdb.bootstrap;

import com.pfseven.smdb.base.AbstractLogComponent;
import com.pfseven.smdb.domain.Movie;
import com.pfseven.smdb.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DemoRunner extends AbstractLogComponent implements CommandLineRunner {

    private final MovieService movieService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("=============================");
        logger.info("******** Find Movie By ID ***********");
        Movie foundMovie = movieService.find(1L);
        Optional.ofNullable(foundMovie).ifPresent(movie -> logger.info(movie.toString()));
        logger.info("=============================");
        logger.info("=============================");
    }
}
