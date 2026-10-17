# Selenium TestNG Automation Framework

**Author:** [sdet-ritusolanki](https://github.com/sdet-ritusolanki)

A Java-based UI test automation framework built from scratch using Selenium WebDriver, TestNG, and Maven. The framework follows the Page Object Model (POM) design pattern and provides reusable browser management, configuration handling, explicit waits, logging, and failure screenshots.

## Project Overview

This project demonstrates how to design, implement, and maintain a reusable UI automation framework with a clear separation between test cases, page objects, and framework utilities.

### Technology Stack

- **Java 17** — programming language
- **Selenium WebDriver 4.27.0** — browser automation
- **TestNG 7.10.2** — test execution and assertions
- **Apache Maven** — dependency management and build automation
- **Log4j2 2.24.3** — execution logging
- **Git and GitHub** — version control and source code hosting

## Framework Features

- Page Object Model (POM) for reusable page interactions
- Centralized WebDriver creation through `DriverFactory`
- Reusable test setup and teardown through `BaseTest`
- Configurable application URL, browser, and timeout
- Configuration loading through `ConfigReader`
- Explicit waits through `WaitUtils`
- Automatic screenshots when tests fail
- Console and file-based logging through Log4j2
- TestNG suite configuration through `testng.xml`
- Maven-based test execution and Surefire reports
- Basic browser selection for Chrome and Firefox

## Project Structure

```text
SeleniumTestNGFramework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/automation/
│   │   │       ├── config/
│   │   │       │   └── ConfigReader.java
│   │   │       ├── factory/
│   │   │       │   └── DriverFactory.java
│   │   │       ├── pages/
│   │   │       │   └── LoginPage.java
│   │   │       └── utils/
│   │   │           ├── WaitUtils.java
│   │   │           └── ScreenshotUtils.java
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   └── com/automation/
│       │       ├── base/
│       │       │   └── BaseTest.java
│       │       └── tests/
│       │           ├── BrowserTest.java
│       │           ├── LoginTest.java
│       │           └── ConfigReaderTest.java
│       └── resources/
│           ├── config.properties
│           └── log4j2.xml
├── test-output/
│   ├── logs/
│   └── screenshots/
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

## Prerequisites

Install the following before running the framework:

- JDK 17
- Apache Maven
- Google Chrome for Chrome tests, or Firefox for Firefox tests
- Git (optional for running tests, required for repository management)

Verify your Java and Maven installations:

```bash
java -version
mvn -version
```

## Configuration

The framework reads its configuration from `src/test/resources/config.properties`.

```properties
baseUrl=https://www.saucedemo.com/
browser=chrome
timeout=10
```

| Property | Description |
|---|---|
| `baseUrl` | Application URL under test |
| `browser` | Browser selection: `chrome` or `firefox` |
| `timeout` | Maximum explicit-wait duration in seconds |

Change the browser property to `firefox` to run against Firefox, provided the browser is installed and the environment supports Selenium Manager.

## How to Run the Tests

Clone the repository:

```bash
git clone https://github.com/sdet-ritusolanki/SeleniumTestNGFramework.git
```

Navigate to the project directory:

```bash
cd SeleniumTestNGFramework
```

Execute the configured TestNG suite:

```bash
mvn clean test
```

The Maven Surefire plugin uses `testng.xml` to select the test classes.

## Test Scenarios

The current suite includes:

- Browser navigation and page-title verification
- Successful login using the SauceDemo demo account
- Application URL configuration verification
- Browser configuration verification

The login test validates navigation to the inventory page and checks the expected page title.

## Logging and Failure Evidence

### Execution Logs

Log4j2 writes execution logs to:

```text
test-output/logs/automation.log
```

The logs include browser lifecycle events, test outcomes, and failure information.

### Failure Screenshots

Screenshots are captured when a test fails and saved under:

```text
test-output/screenshots/
```

The screenshot filenames include the test method name and a timestamp to help identify the corresponding execution.

### Test Reports

Maven Surefire generates test reports under:

```text
target/surefire-reports/
```

These reports contain test execution results and failure details.

## Framework Design

### DriverFactory

Centralizes WebDriver creation and browser selection.

### BaseTest

Manages browser setup, failure screenshot capture, and teardown through TestNG lifecycle annotations.

### Page Objects

Encapsulate page locators and UI actions separately from test assertions.

### ConfigReader

Loads framework settings from a properties file and validates required values.

### WaitUtils

Provides reusable explicit waits for element visibility, clickability, and URL conditions.

### ScreenshotUtils

Captures browser screenshots to support failure investigation.

## Future Enhancements

Planned improvements include:

- GitHub Actions continuous integration
- More positive and negative login scenarios
- Data-driven testing
- Additional page objects and reusable test data
- Enhanced reporting with screenshots attached to failed tests
- Thread-safe WebDriver management for parallel execution
- Environment-specific configuration and command-line overrides

## Author

**GitHub:** [sdet-ritusolanki](https://github.com/sdet-ritusolanki)

This project is intended to demonstrate practical skills in Java automation framework design, Selenium WebDriver, TestNG, Maven, reusable utilities, and maintainable test architecture.