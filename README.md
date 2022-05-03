# IoT Bay Spring Boot

## Installation Instructions

1. Install Java <https://adoptium.net/temurin/releases>

2. Run the project with `./gradlew bootRun` on linux/mac or
   `.\gradlew.bat bootRun` on windows

3. Open the project at `localhost:8080`.

## Testing Instructions

1. Run `./gradlew test`

## Project Structure

The project is a regular MVC Project, the project layout is as follows

Each directory represents a package, e.g. `IoTBayApplication.java` is in the
folder `java/au/edu/uts/isd/iotbay` which corresponds to the package
`au.edu.uts.isd.iotbay`.

The projects **views** are stored at `src/main/resources/templates/`

The projects **controllers** are stored at
`src/main/java/au/edu/uts/isd/iotbay/controllers`.

The project has three packages for models.

- The `dao` package are the models which perform queries against the database.
- The `data` package are java representations of SQL Schema.
- The `forms` package are representations of java input forms.