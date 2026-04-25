package com.cinereserve.cinereserve.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * MEMBER 2 | SOLID: Open/Closed Principle (OCP)
 *   Movie is CLOSED for modification. New movie types added via MovieFactory.
 *
 * MEMBER 2 | GRASP: Information Expert
 *   Movie is the expert for its own data — isHighlyRated(), getFormattedDuration()
 *   live here because Movie has all the info needed.
 *
 * DESIGN PATTERN: FACTORY (Creational) — Member 2
 *   All Movie objects are created via MovieFactory.createMovie(), never new Movie().
 */
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;
    private String genre;
    private String description;
    private String language;
    private double rating;
    private int duration; // minutes
    private LocalDate releaseDate;

    /** GRASP Information Expert: Movie knows if it's highly rated */
    public boolean isHighlyRated() { return this.rating >= 7.5; }

    /** GRASP Information Expert: Movie formats its own duration */
    public String getFormattedDuration() {
        return (duration / 60) + "h " + (duration % 60) + "m";
    }

    public Long getMovieId()                 { return movieId; }
    public void setMovieId(Long id)          { this.movieId = id; }
    public String getTitle()                 { return title; }
    public void setTitle(String title)       { this.title = title; }
    public String getGenre()                 { return genre; }
    public void setGenre(String genre)       { this.genre = genre; }
    public String getDescription()           { return description; }
    public void setDescription(String d)     { this.description = d; }
    public String getLanguage()              { return language; }
    public void setLanguage(String l)        { this.language = l; }
    public double getRating()                { return rating; }
    public void setRating(double rating)     { this.rating = rating; }
    public int getDuration()                 { return duration; }
    public void setDuration(int duration)    { this.duration = duration; }
    public LocalDate getReleaseDate()        { return releaseDate; }
    public void setReleaseDate(LocalDate d)  { this.releaseDate = d; }
}
