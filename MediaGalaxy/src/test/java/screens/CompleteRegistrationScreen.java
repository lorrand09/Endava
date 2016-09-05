package screens;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Sleeper;

import utils.DriverHelper;

public class CompleteRegistrationScreen extends LoadableComponent<CompleteRegistrationScreen> {
    private WebDriver driver;
    @FindBy(how = How.XPATH, using = "//li[@class='success-msg']//span")
    private WebElement successfullLoginMessage;

    public CompleteRegistrationScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CompleteRegistrationScreen checkRegistration() throws Error {
        Assert.assertEquals("Felicitari", driver.getTitle());
        return this;
    }

    @Override
    protected void isLoaded() throws Error {
        System.out.print("is loaded");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Assert.assertEquals("Mulțumim ca v-ați înregistrat pe Magazinul Media Galaxy.", successfullLoginMessage.getText());
    }    

    @Override
    protected void load() {
        System.out.print("load");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

}
