# Selenium Test Automation Framework with Cucumber

## Overview
This repository hosts a sophisticated Selenium-based test automation framework utilizing Cucumber, Java, Cucumber Dependency Injection (DI), Factory Design Pattern, and the Page Object Model (POM). The framework is designed to enable scalable, maintainable, and efficient automation testing, supporting Behavior-Driven Development (BDD).

## Features
- **Behavior-Driven Development (BDD)**: Define test cases in plain English using Cucumber.
- **Selenium WebDriver Integration**: Interact with web applications across multiple browsers.
- **Dependency Injection**: Use Cucumber's DI capabilities to manage object creation and dependencies.
- **Factory Design Pattern**: Implement factory classes to encapsulate the creation of page objects, ensuring better modularity and flexibility.
- **Page Object Model (POM)**: Organize and maintain web elements and interactions using POM.
- **Cross-Browser Testing**: Support for running tests on various browsers such as Chrome, Firefox, etc.
- **Parallel Execution**: Ability to run tests in parallel for faster execution.
- **Comprehensive Reporting**: Generate detailed test execution reports with extent report.

## Prerequisites
- Java JDK 8 or higher
- Maven
- IntelliJ IDEA

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/WkjuniorDiaz/Selenium-Web-Automation.git
   ```
2. Navigate to the project directory:
   ```bash
   cd your-repo
   ```
3. Install the required dependencies using Maven:
   ```bash
   mvn clean install
   ```

## Project Structure
- `src/test/java`: Contains the main automation codebase.
  - `features`: Stores the Cucumber feature files written in Gherkin syntax.
  - `stepDefinitions`: Houses the Cucumber step definitions.
  - `runner`: Contains test runner classes.
  - `pagesObjects`: Implements the Page Object Model (POM) classes.
      - `PageObjectManager.java`: Implements Factory Design Pattern classes to handle complex object creation.
  - `utils`: Contains dependency injection configuration and Utility classes 
- `src/test/resources`: Contains Cucumber feature files and configuration files.
  - `globalProperties`: Holds browser and url to run test cases.
  - extent.properties: Holds configuration of the reporter

## Running Tests
### Run All Tests
To execute all test cases, use:
```bash
mvn test
```

## Report
To visualize the report after the execution of the TestRunner we need to use the following steps:
1. Under the project tree, on the package "test-output", search for the cucumberReports directory.
2. Right click on the file AutomationReport.html
3. Select "Open in" 
4. Select "Browser" choose the browser you prefer.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

