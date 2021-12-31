package com.pfseven.smdb.controller;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Person;
import com.pfseven.smdb.domain.Series;
import com.pfseven.smdb.service.BaseService;
import com.pfseven.smdb.service.SeriesService;
import com.pfseven.smdb.transfer.ApiResponse;
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

    @GetMapping("/{title}")
    public ResponseEntity<ApiResponse<Series>> get(@PathVariable final String title) {
        return ResponseEntity.ok(ApiResponse.<Series>builder().data(seriesService.get(title)).build());
    }

    @GetMapping("/{title}")
    public ResponseEntity<ApiResponse<Series>> find(@PathVariable final String title) {
        return ResponseEntity.ok(ApiResponse.<Series>builder().data(seriesService.find(title)).build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addEpisode(@Valid @RequestBody final Series series,
                           @Valid @RequestBody final Episode episode) {
        if (seriesService.exists(series)) {
            seriesService.addEpisode(series, episode);
        }
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEpisode(@Valid @RequestBody final Series series,
                              @Valid @RequestBody final Episode episode) {
        if (seriesService.exists(series)) {
            seriesService.removeEpisode(series, episode);
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEpisode(@Valid @RequestBody final Series series,
                              @Valid @RequestBody final Episode episode) {
        if (seriesService.exists(series)) {
            seriesService.updateEpisode(series, episode);
        }
    }

    @Override
    protected BaseService<Series, Long> getService() {
        return seriesService;
    }
}
