package com.pfseven.smdb.controller;

import com.pfseven.smdb.domain.Genre;
import com.pfseven.smdb.domain.Movie;
import com.pfseven.smdb.service.BaseService;
import com.pfseven.smdb.service.MovieService;
import com.pfseven.smdb.transfer.ApiResponse;
import com.pfseven.smdb.transfer.TopRatedMovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
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

    @GetMapping(params = "r")
    public ResponseEntity<ApiResponse<List<Movie>>> findByRating(@RequestParam("r") final Double rating) {
        return ResponseEntity.ok(ApiResponse.<List<Movie>>builder().data(movieService.findMoviesByRatingIsGreaterThanEqual(rating)).build());
    }

    @GetMapping("/top")
    public ResponseEntity<ApiResponse<TopRatedMovieDto>> findTopRatedMovie() {
        return ResponseEntity.ok(ApiResponse.<TopRatedMovieDto>builder().data(movieService.findTopRatedMovie()).build());
    }

    @GetMapping(params = "g")
    public ResponseEntity<ApiResponse<List<Movie>>> findMoviesByGenresContaining(@RequestParam("g") final String genre) {
        Genre genre1 = Genre.valueOf(genre);
        return ResponseEntity.ok(ApiResponse.<List<Movie>>builder().data(movieService.findMoviesByGenresContaining(genre1)).build());
    }

    @Override
    protected BaseService<Movie, Long> getService() {
        return movieService;
    }
}
