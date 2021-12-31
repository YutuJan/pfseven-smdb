package com.pfseven.smdb.controller;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Movie;
import com.pfseven.smdb.service.BaseService;
import com.pfseven.smdb.service.EpisodeService;
import com.pfseven.smdb.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/episode")
public class EpisodeController extends AbstractController<Episode> {
    private final EpisodeService episodeService;

    @GetMapping("/{title}")
    public ResponseEntity<ApiResponse<Episode>> get(@PathVariable final String title) {
        return ResponseEntity.ok(ApiResponse.<Episode>builder().data(episodeService.get(title)).build());
    }

    @GetMapping("/{title}")
    public ResponseEntity<ApiResponse<Episode>> find(@PathVariable final String title) {
        return ResponseEntity.ok(ApiResponse.<Episode>builder().data(episodeService.find(title)).build());
    }

    @Override
    protected BaseService<Episode, Long> getService() {
        return episodeService;
    }
}
