package general;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import screens.CreateAccountScreen;
import screens.RegistrationCompleteScreen;
import util.CreateAccountData;

public class CreateAccount {
    private WebDriver driver;
    private CreateAccountScreen createAccountScreen;
    private CreateAccountData createAccount;
    private RegistrationCompleteScreen registration;

    @BeforeScenario
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Given("I open the new account page")
    public void givenIOpenCreateAccountPage() {
        createAccountScreen = new CreateAccountScreen(driver).get();

    }

    @When("I submit the form with valid data")
    public void whenISubmitFormWithValidData() {

        createAccountScreen.fillFirstName();
        createAccountScreen.fillLastName();
        createAccountScreen.fillEmail();
        createAccountScreen.fillPhone();
        createAccountScreen.fillPassword();
        createAccountScreen.fillConfirmPassword();
        createAccountScreen.checkNewsletter();
        createAccountScreen.checkTerms();
        createAccountScreen.Create();

    }

    @Then("I should see the data created")
    public void thenIShouldSeeTheDataCreated() {
        registration = new RegistrationCompleteScreen(driver);
        registration.isLoaded();;
    }
}
