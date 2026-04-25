package com.cinereserve.cinereserve.repository;
import com.cinereserve.cinereserve.model.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByMovieMovieId(Long movieId);
}
