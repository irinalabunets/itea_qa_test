import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Base test where describe the main things to the all tests. Write the total for all tests
 */
public class BaseTest {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * In this method write what we doing before each class
     */
    @BeforeClass
    public void setUp () {
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Close browser after each test
     */
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

