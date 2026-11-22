# Stockit — CPAN-228 Deliverable 1

A responsive Spring Boot inventory management web application. **Phase 1 only**: front-end, validated product creation, and persistent database integration.

## Requirements
- Java 17 or later (Java 17 recommended)
- Maven 3.9+ (or import `pom.xml` into IntelliJ / Eclipse / NetBeans)
- Internet connection on first build to download dependencies and Bootstrap CDN assets

## Run
```bash
mvn clean spring-boot:run
```
Open http://localhost:8080 . To package: `mvn clean package` then `java -jar target/inventory-phase1-1.0.0.jar`.

## Features
- Home, About, User Guide, product list, add product and product detail pages
- Bootstrap responsive design and Thymeleaf templates
- Bean Validation on required fields, category enum, SKU format, numeric ranges and duplicate SKUs
- H2 **file-based** database under `./data/` (persists across restarts)
- Spring Data JPA paging, sorting (name, price, quantity, date) and filtering (category, low/in stock)
- 12 realistic sample products inserted on startup with `data.sql` (MERGE avoids duplicating seeds)

## Demo flow
1. Browse Inventory and observe seeded records.
2. Filter category `ELECTRONICS` and stock status `LOW`.
3. Sort by `price` descending and use pagination.
4. Try saving a blank form; verify validation errors.
5. Add a unique SKU, e.g. `EL-9001`; confirm redirect to its detail page.
6. Restart and verify the new product remains saved.

## Database
JDBC URL: `jdbc:h2:file:./data/inventorydb;DB_CLOSE_ON_EXIT=FALSE`, username `sa`, empty password. Optional developer H2 console at `/h2-console` (local development only). Hibernate creates/updates the schema and Spring runs `data.sql` after Hibernate initialization.

## Project structure
`controller/` request handling; `model/` entity and enum; `repository/` JPA database queries; `templates/` Thymeleaf pages; `static/css/` custom styling; `data.sql` sample records.

## Submission
Commit the project to GitHub incrementally. Record each team member's actual contributions in the README before submission. Submit repository URL and short demonstration video on Blackboard as instructed. Do not claim tests or screenshots not actually performed.

## Future deliverables (not included)
Deliverable 2: authentication, BCrypt, roles, protected routes, admin edit/delete. Deliverable 3: REST microservice, profiles, PostgreSQL and Docker.
