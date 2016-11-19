import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginRegistrationPage;

/**
 * Class wiht all login and registration tests at the linkedin
 */
public class LoginRegistrationTest extends BaseTest{
    
    /**
     * Error massage at the empty form after user click submit
     */
    @Test
    public void errorMessageOnEmptyFormSubmit () {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        registrationPage.registrationFormFillAndSubmit("", "", "", "");
        Assert.assertEquals(registrationPage.getErrorMessageText(), "Укажите имя", "Expected error message was not found on page");
    }
    /**
     * Error massage at the filled fields form and mistake at the email after user click submit
     */
    @Test
    public void errorMessageOnFillFormBadEmailSubmit (){
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        registrationPage.registrationFormFillAndSubmit("irina", "labunets", "labunetsirina@gmail", "edcvfr789");
        Assert.assertEquals(registrationPage.getErrorMessageText(), "Укажите действительный адрес электронной почты", "Expected error message was not found on page");
    }
    /**
     * List of value that will be used in the test
     * @return value for complete registration form
     */
    @DataProvider(name = "dataForRegistration")
    public Object[][] dataForRegistration(){
        return new Object[][] {
                { "","","","Укажите имя"},
                { "irina","hhhhhh", "", "Укажите действительную фамилию" },
                { "irina","", "", "Укажите фамилию" },
                { "irina","labunets", "", "Укажите свой адрес электронной почты" },
                { "irina", "labunets", "labunetsir@gmail.com", "Укажите пароль"}
        };
    }

    /**
     * Fix different error massages from registration form
     * @param firstNameForRegistration value for first name, user enter his first name
     * @param lastNameForRegistration value for last name, user enter his last name
     * @param emailForRegistration value for email, user enter his email
     * @param expectedErrorMassage error massage
     */
    @Test (dataProvider = "dataForRegistration")
    public void errorMassagesFromRegistrationForm(String firstNameForRegistration, String lastNameForRegistration, String emailForRegistration, String expectedErrorMassage){
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        registrationPage.registrationFormFillAndSubmit(firstNameForRegistration, lastNameForRegistration, emailForRegistration, "");
        Assert.assertEquals(registrationPage.getErrorMessageText(),expectedErrorMassage, "Expected error message was not found on page");

    }
    /**
     * Successful authorization of user
     */
    @Test
    public void successfulLoginTest () {
        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage(getDriver());
        HomePage homePage = loginRegistrationPage.loginFormFillAndSubmit("irina.la@ukr.net", "edcvfr789");
        Assert.assertTrue(homePage.isPageLoaded());
    }
}

