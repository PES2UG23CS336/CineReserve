## Repository Layer – Movie & Show

The `MovieRepository` and `ShowRepository` handle data access and database interactions for Movie and Show entities.

### Responsibilities

* Perform CRUD operations on Movie and Show data
* Interface with the database using JPA
* Provide data to the Service layer

### Design Principles

* **Abstraction:** Hides database implementation details from higher layers
* **Low Coupling:** Service layer interacts with repositories via interfaces
* **Separation of Concerns:** Keeps persistence logic isolated

### Notes

* Extends JPA repository interfaces
* No business logic is implemented here
* Used only for data storage and retrieval
