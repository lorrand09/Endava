package screens;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.ActionsHelper;
import utils.WaitHelper;

public class MainScreen extends LoadableComponent<MainScreen> {

    private WebDriver driver;
    WaitHelper waitHelper = WaitHelper.INSTANCE;
    ActionsHelper actionHelper = ActionsHelper.INSTANCE;

    @FindBy(id = "SearchInput")
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = ".//*[@id='search_mini_form']/button")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='js-Header-cont']/a")
    private WebElement logIn;
    @FindBy(how = How.XPATH, using = "//div[@id='js-Header-cont']//input[@name='login[username]']")
    private WebElement emailLogIn;
    @FindBy(how = How.XPATH, using = ".//*[@id='js-Header-cont']/div/div/form/input[2]")
    private WebElement passwordLogIn;
    private By authentication = By.xpath(".//button[@class = 'Button Button--small Button-primary Header-contWindow-buttonPrimary']");

    public MainScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OrderScreen LogInForm() {
        logIn.click();
        emailLogIn.sendKeys("lorrand09@yahoo.com");
        passwordLogIn.sendKeys("CLUJ2015");
        actionHelper.clickOn(authentication);
        return new OrderScreen(driver).get();

    }

    public MainScreen search() {
        searchField.sendKeys(randomString(10));
        searchButton.click();
        return this;

    }

    public static String randomString(int length) {
        Random random = new SecureRandom();
        char[] result = new char[length];
        char[] CHARSET_AZ_09 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (int i = 0; i < result.length; i++) {
            // picks a random index out of character set > random character
            int randomCharIndex = random.nextInt(CHARSET_AZ_09.length);
            result[i] = CHARSET_AZ_09[randomCharIndex];

        }
        return new String(result);
    }

    @Override
    protected void isLoaded() throws Error {
        System.out.print("isLoaded");
        Assert.assertEquals(driver.getPageSource().contains("Bine ai venit !"), true);

    }

    @Override
    protected void load() {
        System.out.print("load");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
