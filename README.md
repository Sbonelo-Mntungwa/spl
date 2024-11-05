# Span Premier League

## Overview
This project is a Java application that reads match scores from a file and updates a table with the results.

## Project Structure

The project structure for the SpanPremierLeague is as follows:

```
SpanPremierLeague/
├── build.gradle
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── Main.java
│   │   └── resources/
│   │       └── matches.txt
│   └── test/
│       └── java/
│           └── MainTest.java
└── README.md
```

- `build.gradle`: The Gradle build file for the project.
- `src/main/java/Main.java`: The main Java application file.
- `src/main/resources/matches.txt`: The file containing match scores.
- `src/test/java/MainTest.java`: The unit test file for the main application.
- `README.md`: The project documentation file.

## How to Set Up Gradle

1. **Install Homebrew** (if you don't have it already):
    ```bash
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    ```

2. **Install Gradle using Homebrew**:
    ```bash
    brew install gradle
    ```

3. **Verify the installation**:
    ```bash
    gradle -v
    ```

4. **Navigate to the project directory**:
    ```bash
    cd SpanPremierLeague
    ```

5. **Generate the Gradle wrapper**:
    ```bash
    gradle wrapper
    ```

## How to Compile and Run the Application

1. **Navigate to the project directory**:
    ```bash
    cd SpanPremierLeague
    ```

2. **Compile the Java file**:
    ```bash
    javac src/main/java/Main.java
    ```

3. **Run the compiled class**:
    ```bash
    java -cp src/main/java Main src/main/resources/matches.txt path/to/output/file.txt
    ```
    - `src/main/resources/matches.txt`: The input file containing match scores.
    - `path/to/output/file.txt`: The output file where the results will be written.

## How to Run Tests

1. **Navigate to the project directory**:
    ```bash
    cd SpanPremierLeague
    ```

2. **Run the tests using Gradle**:
    ```bash
    ./gradlew test
    ```
## How to View Test Results

1. **Navigate to the project directory**:
    ```bash
    cd SpanPremierLeague
    ```

2. **Run the tests using Gradle**:
    ```bash
    ./gradlew test
    ```

3. **View the test results**:
    After running the tests, you can view the test results in the following directory:
    ```
    build/reports/tests/test/index.html
    ```

    Open the `index.html` file in your web browser to view the detailed test results.

## Additional Information

- The `matches.txt` file should contain match scores in the following format:
    ```
    TeamA 3, TeamB 1
    TeamC 2, TeamD 2
    TeamA 1, TeamC 1
    ```

- The `MainTest.java` file contains unit tests for the `Main.java` file, including tests for empty files, single matches, draw matches, and file not found scenarios.