package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Home page - page object, that extends from base page
 */
public class HomePage extends BasePage{

    @FindBy (xpath = "//div[@id='main-site-nav']//a[@class='nav-link' and @href='/home?trk=nav_responsive_tab_home']")
    private WebElement homeMenuLink;

    @FindBy (id = "advanced-search")
    private WebElement advansedSearchLink;

    /**
     * Constructor for home page
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    /**
     * Waite until page is loaded
     * @return WebElement is visible at the page
     */
    public boolean isPageLoaded() {
        return waitForElementDisplayed(homeMenuLink, 5).isDisplayed();
    }

    /**
     * Click for link advanse search .
     * @return Search page, that we are switched to the another page advansed people search
     */
    public SearchPage clickForAdvansedSearchLink () {
        advansedSearchLink.click();
        return new SearchPage (driver);
    }
}

