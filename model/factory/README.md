## Factory Layer – MovieFactory

The `MovieFactory` implements the Factory Design Pattern to handle the creation of Movie objects.

### Responsibilities

* Encapsulate object creation logic for Movie
* Provide a centralized method to create Movie instances
* Simplify object instantiation for controllers and services

### Design Principles

* **Factory Pattern:** Separates object creation from usage
* **Open-Closed Principle (OCP):** New types of Movie objects can be added without modifying existing code
* **Low Coupling:** Reduces dependency on direct object instantiation

### Notes

* Improves code maintainability and scalability
* Prevents duplication of object creation logic
* Used primarily by the service layer
