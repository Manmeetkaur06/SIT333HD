package web.functional;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import web.MyServer;

public class StemGameFunctionalHDTest {

    private static final String BASE_URL = "http://localhost:8080";
    private static ConfigurableApplicationContext appContext;

    private WebDriver driver;

    @BeforeClass
    public static void startApplication() {
        appContext = SpringApplication.run(MyServer.class);
    }

    @AfterClass
    public static void stopApplication() {
        if (appContext != null) {
            appContext.close();
        }
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");

        if (Boolean.getBoolean("selenium.headless")) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1400,1000");
        }

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void waitForUrlContains(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(webDriver -> webDriver.getCurrentUrl().contains(expectedText));
    }

    private void waitForPageText(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(webDriver -> webDriver.getPageSource().contains(expectedText));
    }

    private void setDate(By locator, String dateValue) {
        WebElement dateElement = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('change'));",
                dateElement,
                dateValue
        );
    }

    private void submitCurrentForm() {
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    private void loginSuccessfully() {
        driver.get(BASE_URL + "/login");

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("ahsan");

        driver.findElement(By.name("passwd")).clear();
        driver.findElement(By.name("passwd")).sendKeys("ahsan_pass");

        setDate(By.name("dob"), "2000-01-01");

        submitCurrentForm();
        waitForUrlContains("/q1");

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
    }

    private void answerQ1Correctly() {
        driver.findElement(By.name("number1")).clear();
        driver.findElement(By.name("number1")).sendKeys("2");

        driver.findElement(By.name("number2")).clear();
        driver.findElement(By.name("number2")).sendKeys("3");

        driver.findElement(By.name("answer")).clear();
        driver.findElement(By.name("answer")).sendKeys("5");

        submitCurrentForm();
        waitForUrlContains("/q2");

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
    }

    private void answerQ2Correctly() {
        driver.findElement(By.name("number1")).clear();
        driver.findElement(By.name("number1")).sendKeys("8");

        driver.findElement(By.name("number2")).clear();
        driver.findElement(By.name("number2")).sendKeys("3");

        driver.findElement(By.name("answer")).clear();
        driver.findElement(By.name("answer")).sendKeys("5");

        submitCurrentForm();
        waitForUrlContains("/q3");

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
    }

    private void answerQ3Correctly() {
        driver.findElement(By.name("number1")).clear();
        driver.findElement(By.name("number1")).sendKeys("4");

        driver.findElement(By.name("number2")).clear();
        driver.findElement(By.name("number2")).sendKeys("3");

        driver.findElement(By.name("answer")).clear();
        driver.findElement(By.name("answer")).sendKeys("12");

        submitCurrentForm();
        waitForUrlContains("/q4");

        Assert.assertTrue(driver.getCurrentUrl().contains("/q4"));
    }

    private void answerQ4Correctly() {
        setDate(By.name("startDate"), "2026-05-14");

        driver.findElement(By.name("days")).clear();
        driver.findElement(By.name("days")).sendKeys("7");

        setDate(By.name("answerDate"), "2026-05-21");

        submitCurrentForm();
        waitForUrlContains("/q5");

        Assert.assertTrue(driver.getCurrentUrl().contains("/q5"));
    }

    private void answerQ5Correctly() {
        setDate(By.name("startDate"), "2026-05-14");

        driver.findElement(By.name("days")).clear();
        driver.findElement(By.name("days")).sendKeys("10");

        setDate(By.name("answerDate"), "2026-05-04");

        submitCurrentForm();
        waitForUrlContains("/q6");

        Assert.assertTrue(driver.getCurrentUrl().contains("/q6"));
    }

    private void answerQ6Correctly() {
        driver.findElement(By.name("mass")).clear();
        driver.findElement(By.name("mass")).sendKeys("50");

        driver.findElement(By.name("volume")).clear();
        driver.findElement(By.name("volume")).sendKeys("10");

        driver.findElement(By.name("answer")).clear();
        driver.findElement(By.name("answer")).sendKeys("5");

        submitCurrentForm();
        waitForUrlContains("/success");

        Assert.assertTrue(driver.getCurrentUrl().contains("/success"));
    }

    @Test
    public void fullStemGameFlowShouldReachSuccessPage() {
        loginSuccessfully();
        answerQ1Correctly();
        answerQ2Correctly();
        answerQ3Correctly();
        answerQ4Correctly();
        answerQ5Correctly();
        answerQ6Correctly();

        Assert.assertTrue(driver.getPageSource().contains("Congratulations"));
    }

    @Test
    public void incorrectLoginShouldRemainOnLoginPage() {
        driver.get(BASE_URL + "/login");

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("wronguser");

        driver.findElement(By.name("passwd")).clear();
        driver.findElement(By.name("passwd")).sendKeys("wrongpass");

        setDate(By.name("dob"), "2000-01-01");

        submitCurrentForm();
        waitForUrlContains("/login");
        waitForPageText("Incorrect credentials");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        Assert.assertTrue(driver.getPageSource().contains("Incorrect credentials"));
    }

    @Test
    public void q4WrongDateAnswerShouldRemainOnQ4() {
        loginSuccessfully();
        answerQ1Correctly();
        answerQ2Correctly();
        answerQ3Correctly();

        setDate(By.name("startDate"), "2026-05-14");
        driver.findElement(By.name("days")).clear();
        driver.findElement(By.name("days")).sendKeys("7");
        setDate(By.name("answerDate"), "2026-05-20");

        submitCurrentForm();
        waitForUrlContains("/q4");
        waitForPageText("Wrong date answer");

        Assert.assertTrue(driver.getCurrentUrl().contains("/q4"));
        Assert.assertTrue(driver.getPageSource().contains("Wrong date answer"));
    }

    @Test
    public void q5WrongDateAnswerShouldRemainOnQ5() {
        loginSuccessfully();
        answerQ1Correctly();
        answerQ2Correctly();
        answerQ3Correctly();
        answerQ4Correctly();

        setDate(By.name("startDate"), "2026-05-14");
        driver.findElement(By.name("days")).clear();
        driver.findElement(By.name("days")).sendKeys("10");
        setDate(By.name("answerDate"), "2026-05-05");

        submitCurrentForm();
        waitForUrlContains("/q5");
        waitForPageText("Wrong date answer");

        Assert.assertTrue(driver.getCurrentUrl().contains("/q5"));
        Assert.assertTrue(driver.getPageSource().contains("Wrong date answer"));
    }

    @Test
    public void q6WrongScienceAnswerShouldRemainOnQ6() {
        loginSuccessfully();
        answerQ1Correctly();
        answerQ2Correctly();
        answerQ3Correctly();
        answerQ4Correctly();
        answerQ5Correctly();

        driver.findElement(By.name("mass")).clear();
        driver.findElement(By.name("mass")).sendKeys("50");

        driver.findElement(By.name("volume")).clear();
        driver.findElement(By.name("volume")).sendKeys("10");

        driver.findElement(By.name("answer")).clear();
        driver.findElement(By.name("answer")).sendKeys("6");

        submitCurrentForm();
        waitForUrlContains("/q6");
        waitForPageText("Wrong science answer");

        Assert.assertTrue(driver.getCurrentUrl().contains("/q6"));
        Assert.assertTrue(driver.getPageSource().contains("Wrong science answer"));
    }
}
