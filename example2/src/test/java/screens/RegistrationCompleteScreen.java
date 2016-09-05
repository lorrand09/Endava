package screens;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegistrationCompleteScreen {

    private WebDriver driver;

    public RegistrationCompleteScreen(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

//    public void checkRegistration() {
//        Assert.assertEquals("Mulțumim ca v-ați înregistrat pe Magazinul Media Galaxy.", driver.getPageSource());
//    }

    protected void load() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void isLoaded() {
        Assert.assertEquals("Mulțumim ca v-ați înregistrat pe Magazinul Media Galaxy.", driver.getTitle());
    }

}
