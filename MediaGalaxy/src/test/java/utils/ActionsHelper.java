package utils;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public enum ActionsHelper {

    INSTANCE;
    static WebDriver driver = DriverHelper.getDriver();
    private WaitHelper waitHelper = WaitHelper.INSTANCE;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(ActionsHelper.class);

    public void moveTo(By by) {

        Actions action = new Actions(driver);
        waitHelper.waitForElementVisibility(by, 10);
        action.moveToElement(driver.findElement(by)).build().perform();

    }

    public void navigate(String URL) {
        driver.get(URL);

    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void verify(By by, String text) {
        waitHelper.waitForElementVisibility(by, 10);
        Assert.assertTrue(driver.findElement(by).getText().contains("Salut " + text + "!"));
        LOG.info("Assert done on element " + by.toString());
    }

    public void clickOn(By by) {
        LOG.info("Waiting for element");
        waitHelper.waitForElementVisibility(by, 20);
        LOG.info("Element is visibile");
        driver.findElement(by).click();
        LOG.info("Clicked on " + by.toString());    

    }

    public String myGetText(By by) {
        String message = driver.findElement(by).getText();
        return message;
    }

    public void selectFromDropdown(By by, String option) {
        LOG.info("Select " + option + " from Dropdown identify by " + by);
        waitHelper.waitForElementVisibility(by, 30);
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByVisibleText(option);

    }

    public void typeText(By by, String text) {
        LOG.info("Sending keys to " + by.toString());
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
        LOG.info("Keys sent to " + by.toString());

    }

    public String getMyTitle() {
        LOG.info("We are on " + driver.getTitle() + " page");
        return driver.getTitle();
    }
}
