## Service Layer – Movie & Show

The `MovieService` and `ShowService` contain the business logic for managing movies and shows.

### Responsibilities

* Process client requests received from controllers
* Apply business rules and validations
* Coordinate between controllers and repositories

### Design Principles

* **Single Responsibility Principle (SRP):** Each service handles one domain (Movie or Show)
* **Low Coupling:** Services interact with repositories and controllers without tight dependency
* **Modularity:** Business logic is centralized for easier maintenance

### Notes

* Acts as the core processing layer of the application
* No direct database interaction (delegates to repository layer)
* Ensures clean separation between logic and data access
