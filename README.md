# Project Management -Spring Boot Project

Develop a web application for project and task management
## Architecture
1. Repository Layer : Handles data persistence. This layer interacts with the database, managing CRUD operations.
2. Service Layer :  Contains the core business logic. It processes the data received from the controller before passing it to the repository for database operations.
3. Entity Layer (Model Layer) : This layer defines the structure of the data in your application and maps the classes to database tables.
4. Presentation Layer (Controller Layer) : The layer where HTTP requests are handled, and responses are returned to the client
