package steps;

import org.apache.commons.configuration.ConfigurationException;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

import screens.MainScreen;
import screens.SearchFailedScreen;
import utils.DriverHelper;

public class SearchSteps {
    private WebDriver driver;
    
    @Given("I open the page on home screen")
    public void openMainPage() {
        driver = DriverHelper.getDriver();
        driver.get("http://www.mediagalaxy.ro");
    }
    
    @When("I submit field with bad data")
    public void submitInValidData() throws ConfigurationException {
        MainScreen mainScreen = new MainScreen(driver).get();        
        mainScreen.search();
    }
    
    @Then("I should see a message for wrong data typed")
    public void dataValidation() {
        SearchFailedScreen searchFailed = new SearchFailedScreen(driver);
        searchFailed.verifySearchField();
    }
    
    @AfterStory
    public void killDriver() {
        DriverHelper.closeBrowser();
    }
}
