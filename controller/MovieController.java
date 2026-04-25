package com.cinereserve.cinereserve.controller;

import com.cinereserve.cinereserve.model.entity.Movie;
import com.cinereserve.cinereserve.service.MovieService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService service;
    public MovieController(MovieService service) { this.service = service; }

    @PostMapping
    public Movie add(@RequestBody Map<String,Object> body) {
        return service.addMovie(
            (String) body.get("title"),
            (String) body.getOrDefault("genre", "Drama"),
            (int) body.getOrDefault("duration", 120),
            (String) body.getOrDefault("language", "English"),
            (String) body.getOrDefault("description", ""),
            body.get("rating") != null ? ((Number) body.get("rating")).doubleValue() : 7.0
        );
    }

    @GetMapping
    public List<Movie> getAll() { return service.getAllMovies(); }

    @GetMapping("/search")
    public List<Movie> search(@RequestParam String q) { return service.search(q); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.deleteMovie(id); }
}
