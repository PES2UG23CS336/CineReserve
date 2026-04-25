package com.cinereserve.cinereserve.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * MEMBER 3 | SOLID: Liskov Substitution Principle (LSP)
 *   ShowBuilder and subclasses (e.g. IMAXShowBuilder) can be substituted
 *   wherever ShowBuilder is expected — build() always returns a valid Show.
 *
 * MEMBER 3 | GRASP: Low Coupling
 *   Show references Movie/Screen only via FK — it does NOT call their methods.
 *
 * DESIGN PATTERN: BUILDER (Creational) — Member 3
 */
@Entity
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Movie movie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "screen_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Screen screen;

    /** GRASP Info Expert: Show calculates its own ticket price */
    public double calculatePrice() {
        if (screen != null && "IMAX".equals(screen.getScreenType())) return 350.0;
        if (screen != null && "3D".equals(screen.getScreenType()))   return 280.0;
        return 200.0;
    }

    public Long getShowId()                   { return showId; }
    public void setShowId(Long id)            { this.showId = id; }
    public LocalDateTime getStartTime()       { return startTime; }
    public void setStartTime(LocalDateTime t) { this.startTime = t; }
    public LocalDateTime getEndTime()         { return endTime; }
    public void setEndTime(LocalDateTime t)   { this.endTime = t; }
    public Movie getMovie()                   { return movie; }
    public void setMovie(Movie movie)         { this.movie = movie; }
    public Screen getScreen()                 { return screen; }
    public void setScreen(Screen screen)      { this.screen = screen; }
    // convenience
    public Long getMovieId()  { return movie  != null ? movie.getMovieId()   : null; }
    public Long getScreenId() { return screen != null ? screen.getScreenId() : null; }
}
