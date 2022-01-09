package com.pfseven.smdb.controller;

import com.pfseven.smdb.domain.BaseModel;
import com.pfseven.smdb.domain.Genre;
import com.pfseven.smdb.domain.Movie;
import com.pfseven.smdb.domain.Series;
import com.pfseven.smdb.service.BaseService;
import com.pfseven.smdb.service.MovieService;
import com.pfseven.smdb.service.SeriesService;
import com.pfseven.smdb.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportsController extends AbstractController {
    private final MovieService movieService;
    private final SeriesService seriesService;

    @Override
    protected BaseService getService() {
        return null;
    }

    @GetMapping(headers = "a=findContentByGenre", params = "g")
    public ResponseEntity<ApiResponse<List<BaseModel>>> findSeriesByGenresContaining(@RequestParam("g") final String genre) {
        Genre genre1 = Genre.valueOf(genre);
        List<Series> series = seriesService.findByGenre(genre1);
        List<Movie> movies = movieService.findMoviesByGenresContaining(genre1);

        List<BaseModel> newList = new ArrayList<>(series);
        newList.addAll(movies);

        return ResponseEntity.ok(ApiResponse.<List<BaseModel>>builder().data(newList).build());
    }
}
