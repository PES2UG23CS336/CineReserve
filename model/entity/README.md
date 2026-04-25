## Model Layer – Movie & Show Entities

The `Movie` and `Show` classes represent the core domain entities of the system. They define the structure of data and encapsulate attributes related to movies and their scheduled shows.

### Responsibilities

* Represent real-world objects (Movie and Show) in the system
* Store essential attributes such as movie details, show timings, and associations
* Act as data carriers between different layers (Controller, Service, Repository)

### Design Principles

* **Information Expert (GRASP):**
  Responsibilities are assigned to classes that have the necessary data.

  * `Movie` manages movie-related data
  * `Show` manages scheduling and timing details

* **Low Coupling:**
  Entities are designed to be independent and interact minimally with other components.

* **Liskov Substitution Principle (LSP):**
  Entities are structured to allow safe extension without breaking existing functionality.

### Structure

* `Movie.java`:

  * Contains attributes like title, genre, duration, etc.
* `Show.java`:

  * Contains attributes like show time, screen, and associated movie

### Notes

* These classes do not contain business logic
* Used by repository layer for database operations
* Serve as the foundation for service and controller layers
