package com.cinereserve.cinereserve.service;

import com.cinereserve.cinereserve.model.builder.ShowBuilder;
import com.cinereserve.cinereserve.model.entity.*;
import com.cinereserve.cinereserve.model.enums.SeatStatus;
import com.cinereserve.cinereserve.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

/**
 * MEMBER 3 | Low Coupling (GRASP):
 *   ShowService is loosely coupled — it depends on repositories
 *   and the ShowBuilder abstraction, not on concrete constructors.
 */
@Service
public class ShowService {
    private final ShowRepository showRepo;
    private final MovieRepository movieRepo;
    private final ScreenRepository screenRepo;
    private final SeatRepository seatRepo;
    private final ShowSeatRepository showSeatRepo;

    public ShowService(ShowRepository showRepo, MovieRepository movieRepo,
                       ScreenRepository screenRepo, SeatRepository seatRepo,
                       ShowSeatRepository showSeatRepo) {
        this.showRepo = showRepo;
        this.movieRepo = movieRepo;
        this.screenRepo = screenRepo;
        this.seatRepo = seatRepo;
        this.showSeatRepo = showSeatRepo;
    }

    /**
     * BUILDER PATTERN used here.
     * FIX: fetches real Movie and Screen from DB before passing to builder.
     * Original bug: was creating hollow entity shells with only ID set.
     */
    public Show add(Long movieId, Long screenId, LocalDateTime startTime) {
        Movie movie   = movieRepo.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found: " + movieId));
        Screen screen = screenRepo.findById(screenId).orElseThrow(() -> new RuntimeException("Screen not found: " + screenId));

        Show show = new ShowBuilder()
                .setMovie(movie)
                .setScreen(screen)
                .setStartTime(startTime)
                .build();

        show = showRepo.save(show);

        // Auto-generate ShowSeats for every seat in the screen
        List<Seat> seats = seatRepo.findByScreenScreenId(screenId);
        for (Seat seat : seats) {
            ShowSeat ss = new ShowSeat();
            ss.setShow(show);
            ss.setSeat(seat);
            ss.setStatus(SeatStatus.AVAILABLE);
            showSeatRepo.save(ss);
        }
        return show;
    }

    public List<Show> getAll()      { return showRepo.findAll(); }
    public Show getById(Long id)    { return showRepo.findById(id).orElseThrow(); }
    public List<Show> getByMovie(Long movieId) { return showRepo.findByMovieMovieId(movieId); }
}
