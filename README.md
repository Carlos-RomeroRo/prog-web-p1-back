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
   cd jpa-springboot
   ```

3. Create environment file:
   - Look for `application.properties.template` in the resources directory and copy it to the new file
   - Edit the `application.properties` file to match your environment values

4. Ignore the properties file:
   - Run `git update-index --skip-worktree .\src\main\resources\application.properties` to ignore the properties file


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
