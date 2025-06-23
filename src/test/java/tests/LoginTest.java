package tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set path to ChromeDriver binary
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        // Set Chrome options for headless execution
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // New headless mode
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Initialize the Chrome driver
        driver = new ChromeDriver(options);
    }

    @Test
    public void testGoogleHomepage() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Assert.assertTrue("Title should contain 'Google'", title.contains("Google"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
