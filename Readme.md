# UI tests + Api tests

### Selenide + RestAssured

## Prerequisites
### What things you need to install:

* [Install Intelij IDEA Community Version](https://www.jetbrains.com/idea/)
* [Install JAVA](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Install Gradle](https://gradle.org/install/) - Dependency Management
* [Install Git](https://git-scm.com/downloads)
* [Install Selenium Grid](https://goo.gl/21wWg8)
* [Download chromedriver](https://chromedriver.storage.googleapis.com/index.html?path=2.33/)


### Installing
1. Create the folder with project
2. In terminal go to project folder
    ```
    cd path_to_project
    ````
3. Clone the project
    ```
    git clone https://github.com/unlimUA/kidslox.git
    ```
4. Launch Selenium Grid on local machine or remote machine
    ```
    java -jar selenium-server-standalone-3.6.0.jar -role hub -port 4444
    java -jar selenium-server-standalone-3.6.0.jar -role webdriver -hub http://localhost:4441/hub/register -port 5000
    ```
5. Include the ChromeDriver location in your PATH environment variable
6. Check url with selenium grid at SelenoidWebDriverProvider `src/test/java/com/kindlox/drivers`
    ```
    URI.create("http://localhost:5000/wd/hub").toURL(),
    ```

## Running the tests
### You can run the test with IntelliJ IDEA
1. Go to `src/test/java/com/kindlox/tests`
2. Select one of thee files
3. Run test with help of Intellij IDEA
### You can run the test with command line
```
./gradlew test --tests com.kidslox.tests.LoginTest
./gradlew test --tests com.kidslox.tests.SignUpTest
./gradlew test --tests com.kidslox.tests.ResetPasswordTest
```
