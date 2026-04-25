package com.cinereserve.cinereserve.repository;
import com.cinereserve.cinereserve.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContainingIgnoreCase(String title);
    List<Movie> findByGenre(String genre);
}
