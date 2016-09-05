package steps;

import org.apache.commons.configuration.ConfigurationException;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

import screens.MainScreen;
import screens.OrderScreen;
import utils.ConfigFileHelper;
import utils.DriverHelper;

public class OrderSteps {
    ConfigFileHelper configHelper = ConfigFileHelper.INSTANCE;
    private WebDriver driver;

    @Given("Login fields registration")
    public void logRegistration() {
        driver = DriverHelper.getDriver();
        driver.get("http://www.mediagalaxy.ro");

    }

    @When("I submit fields with valid data and then I should be loged into my account")
    public void submitValidData() throws ConfigurationException {
        MainScreen mainScreen = new MainScreen(driver).get();
        mainScreen.LogInForm();
    }

    @Then("I should be able to order a specific product")
    public void orderAProduct() {
        OrderScreen orderScreen = new OrderScreen(driver).get();
        orderScreen.orderProduct();
    }

    @AfterStory
    public void killDriver() {
        DriverHelper.closeBrowser();
    }
}
