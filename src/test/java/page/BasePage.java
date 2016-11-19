package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Base page where describe the main things to the other pages
 */
public class BasePage {
    protected WebDriver driver;

    public BasePage (WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Explicitly waiting for WedElement visibility.
     * @param element WebElement that will be explicitly waited.
     * @param timeout Maximum wait time in seconds.
     * @return WebElement that was explicitly waited.
     */
    public WebElement waitForElementDisplayed (WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilElementDisplayed (WebElement element) {
        return waitForElementDisplayed (element, 10);
    }


}
