# SIT333 HD STEM Game

This project is an enhanced version of the 8.1P STEM game. It starts from the login page, moves through three math questions, then two date utility questions, then one science question, and finally reaches the success page.

## Application flow

1. `/` Welcome page
2. `/login` Login page
3. `/q1` Addition question
4. `/q2` Subtraction question
5. `/q3` Multiplication question
6. `/q4` Date after question
7. `/q5` Date before question
8. `/q6` Science density question
9. `/success` Completion page

## Test login

- Username: `ahsan`
- Password: `ahsan_pass`
- Date of birth can be any date value

## Run application

```bash
mvn spring-boot:run
```

Then open:

```text
http://localhost:8080
```

## Run tests and coverage

```bash
mvn test
```

JaCoCo coverage report will be generated at:

```text
target/site/jacoco/index.html
```

## Selenium note

The Selenium functional test uses Selenium Manager through Selenium 4.21.0. If Eclipse cannot locate ChromeDriver automatically, add this VM argument in the JUnit run configuration and update the path to your local driver:

```text
-Dwebdriver.chrome.driver=/Users/manmeetkaur/Desktop/SIT333/chromedriver-mac-arm64/chromedriver
```

To run Selenium in headless mode:

```bash
mvn test -Dselenium.headless=true
```
