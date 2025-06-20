### Running Tests with Maven

You can execute tests in your project using Maven's `mvn test` command. Below are the available options:

#### Run All Tests
To run all tests in the project, use:
```bash
mvn test
```
This will execute all test cases across all classes in the project.

#### Run Tests for a Specific Class
To run tests for a specific class, use:
```bash
mvn test -Dtest=FormationTest
```
Example:
```bash
mvn test -Dtest=FormationTest
```
This will run tests only in the `FormationTest` test class.

#### Run Tests for Multiple Classes
You can also specify multiple test classes using patterns:
```bash
mvn test -Dtest=FormationTest,AnotherTestClass
```
Example:
```bash
mvn test -Dtest=FormationTest,AnotherTestClass
```

#### Run a Specific Test Method
To run a specific test method within the `FormationTest` class, use:
```bash
mvn test -Dtest=FormationTest#testGoToFormation
```
Example:
```bash
mvn test -Dtest=FormationTest#testGoToFormation
```
This will execute only the `testGoToFormation` method in the `FormationTest` class.

To run another method, such as `testSearchFormation`, use:
```bash
mvn test -Dtest=FormationTest#testSearchFormation
```
Example:
```bash
mvn test -Dtest=FormationTest#testSearchFormation
```
This will execute only the `testSearchFormation` method in the `FormationTest` class.

#### Notes
- Ensure that test classes follow naming conventions (e.g., ending with `Test`) for Maven to recognize them.
- Use commas to separate multiple class names when specifying patterns.
- Maven supports wildcard patterns for test class names if needed.
- To run specific methods, use the format `<ClassName>#<MethodName>`.