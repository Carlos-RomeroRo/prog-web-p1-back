# jpa-springboot

This is a sample Spring Boot 3.2.2 project with Gradle and Java 17.

## Requirements

- Java 17
- Gradle

## Project Setup

1. Clone this repository:

   ```bash
   git clone https://github.com/keiner5212/jpa-springboot.git
   ```

2. Navigate to the project directory:

   ```bash
   cd prog-web-p1-back
   ```

3. Create environment file:
   - Create a `application-local.properties` in the resources directory
   - Look for `application-local.properties.template` in the resources directory and copy it to the new file
   - Edit the properties in the new file to match your environment values


## Running the Project

To run the project, you can use Gradle from the command line:

```bash
./gradlew bootRun
```

This will start the Spring Boot application on the default port `8080`.

## Using the API

Once the application is up and running, you can access the API at:

```
http://localhost:8080/
```
