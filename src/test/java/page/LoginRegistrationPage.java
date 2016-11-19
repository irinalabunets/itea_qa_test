package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Login and registration pages - page object, that extends from base page
 */
public class LoginRegistrationPage extends BasePage{

    @FindBy(id = "reg-firstname")
    private WebElement firstNameField;

    @FindBy (id = "reg-lastname")
    private WebElement lastNameField;

    @FindBy (id ="reg-email")
    private WebElement emailField;

    @FindBy (id = "reg-password")
    private WebElement passwordField;

    @FindBy (id = "registration-submit")
    private WebElement joinNowButton;

    @FindBy (id = "login-email")
    private WebElement loginEmailField;

    @FindBy (id = "login-password")
    private WebElement loginPasswordField;

    @FindBy (id = "login-submit")
    private WebElement singInButton;

    @FindBy (className = "alert-content")
    private WebElement errorMessageBox;

    /**
     * Constructor for login and registration page
     * @param driver
     */
    public LoginRegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    /**
     * Method for authorization at the linkedin
     * @param loginEmail user login for authorization at linkedin
     * @param loginPassword user password for authorization at linkedin
     * @return Home page, it is means that user is logged on the linkedin
     */
    public HomePage loginFormFillAndSubmit(String loginEmail, String loginPassword) {

        loginEmailField.sendKeys(loginEmail);
        loginPasswordField.sendKeys(loginPassword);
        singInButton.click();
        return new HomePage(driver);
    }
    /**
     * Method for registration at the linkedin
     * @param firstName user name
     * @param lastName user last name
     * @param email user email
     * @param password user password
     */
    public void registrationFormFillAndSubmit(String firstName, String lastName, String email, String password) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        joinNowButton.click();
    }
    /**
     * Get text from error box
     * @return String from error box
     */
    public String getErrorMessageText (){
        return errorMessageBox.getText();
    }
}
