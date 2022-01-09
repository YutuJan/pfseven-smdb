package com.pfseven.smdb.controller;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Series;
import com.pfseven.smdb.service.BaseService;
import com.pfseven.smdb.service.EpisodeService;
import com.pfseven.smdb.service.SeriesService;
import com.pfseven.smdb.transfer.ApiResponse;
import com.pfseven.smdb.transfer.SeriesAndEpisodeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/series")
public class SeriesController extends AbstractController<Series> {
    private final SeriesService seriesService;
    private final EpisodeService episodeService;

    @GetMapping("/get/{title}")
    public ResponseEntity<ApiResponse<Series>> get(@PathVariable final String title) {
        return ResponseEntity.ok(ApiResponse.<Series>builder().data(seriesService.get(title)).build());
    }

    @GetMapping("/find/{title}")
    public ResponseEntity<ApiResponse<Series>> find(@PathVariable final String title) {
        return ResponseEntity.ok(ApiResponse.<Series>builder().data(seriesService.find(title)).build());
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addEpisode(@Valid @RequestBody final SeriesAndEpisodeDto seriesAndEpisodeDto) {
        Series series = seriesAndEpisodeDto.getSeries();
        Episode episode = seriesAndEpisodeDto.getEpisode();

        if (seriesService.exists(series)) {
            seriesService.addEpisode(series, episode);
        }
    }

    @DeleteMapping("/remove/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEpisode(@Valid @RequestBody final SeriesAndEpisodeDto seriesAndEpisodeDto) {
        Series series = seriesAndEpisodeDto.getSeries();
        Episode episode = seriesAndEpisodeDto.getEpisode();

        if (seriesService.exists(series)) {
            seriesService.removeEpisode(series, episode);
        }
    }

    @DeleteMapping("/remove/series_id/{series_id}/episode_id/{episode_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEpisode(@PathVariable("series_id") final Long series_id,
                              @PathVariable("episode_id") final Long episode_id) {
        Series series = seriesService.find(series_id);
        Episode episode = episodeService.find(episode_id);

        if (seriesService.exists(series)) {
            seriesService.removeEpisode(series, episode);
        }
    }

    @DeleteMapping("/remove/series_title/{series_title}/episode_title/{episode_title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEpisode(@PathVariable("series_title") final String series_title,
                              @PathVariable("episode_title") final String episode_title) {
        System.out.println("In SeriesController " + 1);
        Series series = seriesService.find(series_title);
        Episode episode = episodeService.find(episode_title);

        if (seriesService.exists(series)) {
            System.out.println("In SeriesController " + 2);
            seriesService.removeEpisode(series, episode);
        }
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEpisode(@Valid @RequestBody final SeriesAndEpisodeDto seriesAndEpisodeDto) {
        Series series = seriesAndEpisodeDto.getSeries();
        Episode episode = seriesAndEpisodeDto.getEpisode();

        if (seriesService.exists(series)) {
            seriesService.updateEpisode(series, episode);
        }
    }

    @Override
    protected BaseService<Series, Long> getService() {
        return seriesService;
    }
}
