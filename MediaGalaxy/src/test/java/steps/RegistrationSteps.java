package steps;

import org.apache.commons.configuration.ConfigurationException;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

import screens.CompleteRegistrationScreen;
import screens.RegisterScreen;
import utils.ConfigFileHelper;
import utils.Cont;
import utils.DriverHelper;

public class RegistrationSteps {
    ConfigFileHelper configHelper = ConfigFileHelper.INSTANCE;
    private WebDriver driver;

    @Given("I open registration account page")
    public void openRegistrationPage() {
        driver = DriverHelper.getDriver();
        driver.get("http://www.mediagalaxy.ro/customer/account/create/");
    }

    @When("I submit form with valid data")
    public void submitValidData() throws ConfigurationException {
        RegisterScreen register = new RegisterScreen(driver).get();
        Cont cont = configHelper.loadAccountFromConfig();
        register.fillInForm(cont);

    }

    @Then("I should see the data created")
    public void checkAccountRegistered() {
        CompleteRegistrationScreen complete = new CompleteRegistrationScreen(driver).get();
        complete.checkRegistration();
    }

    @AfterStory
    public void killDriver() {
        DriverHelper.closeBrowser();
    }
}
