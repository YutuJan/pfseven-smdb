package com.pfseven.smdb.controller;

import com.pfseven.smdb.domain.Movie;
import com.pfseven.smdb.service.BaseService;
import com.pfseven.smdb.service.MovieService;
import com.pfseven.smdb.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController extends AbstractController<Movie> {
    private final MovieService movieService;

    @GetMapping("/find/{title}")
    public ResponseEntity<ApiResponse<Movie>> find(@PathVariable final String title) {
        return ResponseEntity.ok(ApiResponse.<Movie>builder().data(movieService.find(title)).build());
    }

    @GetMapping("/get/{title}")
    public ResponseEntity<ApiResponse<Movie>> get(@PathVariable final String title) {
        return ResponseEntity.ok(ApiResponse.<Movie>builder().data(movieService.get(title)).build());
    }

    @Override
    protected BaseService<Movie, Long> getService() {
        return movieService;
    }
}
