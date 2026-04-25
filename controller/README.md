## Movie & Show Controller

The `MovieController` and `ShowController` handle all HTTP requests related to movie management and show scheduling.

### Responsibilities

* Provide endpoints to create, view, and manage movies and shows
* Accept client requests and forward them to the service layer
* Return appropriate responses to the client

### Endpoints Overview

* MovieController:

  * Add a new movie
  * View all movies
  * Get movie details

* ShowController:

  * Create a new show
  * View shows for a movie
  * Manage show timings

### Design Principles

* **SRP (Single Responsibility Principle):** Each controller focuses only on its domain (Movie or Show)
* **GRASP Controller:** Acts as an interface between client requests and business logic
* **Low Coupling:** Controllers interact only with service classes

### Design Pattern Used

* **Factory Pattern (MovieFactory):**
  Used for creating movie objects, keeping object creation logic separate from controllers.

### Flow

Client -> Controller -> Service -> Repository -> Database -> Response

### Notes

* No business logic is implemented in controllers
* Controllers only handle request/response flow
* Ensures clean separation of concerns and maintainability
