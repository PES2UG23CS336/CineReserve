package com.cinereserve.cinereserve.service;

import com.cinereserve.cinereserve.model.entity.Movie;
import com.cinereserve.cinereserve.model.factory.MovieFactory;
import com.cinereserve.cinereserve.repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * MEMBER 2 | Open/Closed Principle:
 *   MovieService is open for extension (new movie types via Factory)
 *   but closed for modification of Movie entity itself.
 */
@Service
public class MovieService {
    private final MovieRepository repo;
    public MovieService(MovieRepository repo) { this.repo = repo; }

    /** FACTORY PATTERN used here — all creation goes through MovieFactory */
    public Movie addMovie(String title, String genre, int duration,
                          String language, String description, double rating) {
        Movie movie = MovieFactory.createMovie(title, genre, duration, language, description, rating);
        return repo.save(movie);
    }

    public List<Movie> getAllMovies()    { return repo.findAll(); }
    public Movie getById(Long id)       { return repo.findById(id).orElseThrow(); }

    /** searchMovie() — Customer use case */
    public List<Movie> search(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }

    public void deleteMovie(Long id)    { repo.deleteById(id); }
}
