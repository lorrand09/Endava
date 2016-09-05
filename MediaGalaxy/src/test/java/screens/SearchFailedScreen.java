package screens;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchFailedScreen {
    private WebDriver driver;

    public SearchFailedScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchFailedScreen verifySearchField() {
        Assert.assertTrue(driver.getPageSource().contains("Cautarea nu a generat niciun rezultat"));
        return this;
    }

}
