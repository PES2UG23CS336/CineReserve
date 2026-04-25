package com.cinereserve.cinereserve.model.factory;

import com.cinereserve.cinereserve.model.entity.Movie;
import java.time.LocalDate;

/**
 * ================================================================
 * DESIGN PATTERN : FACTORY METHOD (Creational) — Member 2
 * ================================================================
 * INTENT: Centralise Movie creation. Callers never call `new Movie()`
 *         directly — they go through this factory.
 *
 * OCP (Member 2): Movie.java is CLOSED for modification.
 *   New movie types (PremiumMovie, KidsMovie) are added by extending
 *   this factory — NOT by editing Movie.
 *
 * Information Expert (Member 2): MovieFactory is the expert on
 *   how to build a valid Movie with all required fields set.
 * ================================================================
 */
public class MovieFactory {

    /** Standard movie */
    public static Movie createMovie(String title, String genre, int duration,
                                    String language, String description, double rating) {
        Movie m = new Movie();
        m.setTitle(title);
        m.setGenre(genre);
        m.setDuration(duration);
        m.setLanguage(language);
        m.setDescription(description);
        m.setRating(rating);
        m.setReleaseDate(LocalDate.now());
        return m;
    }

    /** Premium movie — rating floored at 8.0, title tagged [PREMIUM] */
    public static Movie createPremiumMovie(String title, String genre, int duration,
                                           String language, String description, double rating) {
        Movie m = createMovie("[PREMIUM] " + title, genre, duration, language,
                              description + " (Premium Release)", Math.max(rating, 8.0));
        return m;
    }

    /** Kids movie — always Animation, default rating 7.5 */
    public static Movie createKidsMovie(String title, int duration, String description) {
        return createMovie(title, "Animation", duration, "English", description, 7.5);
    }
}
