package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Search page - page object, that extends from base page
 */
public class SearchPage extends BasePage{

    @FindBy (xpath = "//div[@id='advs']/h3")
    private WebElement advancedPeopleSearchForm;

    @FindBy (id = "advs-keywords")
    private WebElement keywordsField;

    @FindBy (name = "submit")
    private WebElement searchButton;

    @FindBy (xpath = "//div[@class='description']")
    private List<WebElement> searchResultDescriptionsList;

    @FindBy (xpath = "//div[@class='search-info']/p[contains(text(), 'results for')]")
    private WebElement resuilsForInfoText;


    /**
     * Constructor for search page
     * @param driver
     */
    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementDisplayed(advancedPeopleSearchForm);
    }
    /**
     * Enter search word
     * @param keyword String search word
     */
    public void searchByKeywordAndSubmit (String keyword) {
        keywordsField.clear();
        keywordsField.sendKeys(keyword);
        searchButton.click();
        waitUntilElementDisplayed(resuilsForInfoText);
    }

    /**
     * Get amount search result on page
     * @return Size, amount notes on the page
     */
    public int getSearchResultsOnPageCount (){
        return searchResultDescriptionsList.size();
    }

    /**
     * Get description from title and convert list of web elements in list of string
     * @return string list description search result
     */
    public List<String> getDescriptionStringList () {
        List<String> searchResultDescriptionStringList = new ArrayList<String>();

        for (WebElement searchResultDescriptionElement : searchResultDescriptionsList){
            searchResultDescriptionStringList.add(searchResultDescriptionElement.getText());
        }
        return searchResultDescriptionStringList;
    }

    /**
     * Check information in title
     * @param searchTerm keyword for search
     * @return list of title
     */
    public boolean Title (String searchTerm) {
        List<String> searchResultDescriptionStringList = new ArrayList<String>();
        for (int i=0; i<searchResultDescriptionStringList.size(); i++){
            if(!searchResultDescriptionStringList.get(i).contains(searchTerm))
                return false;
        }
        return true;
    }
}
