package screens;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class OrderScreen extends LoadableComponent<OrderScreen> {
    private WebDriver driver;
    
    @FindBy(id = "SearchInput")
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = ".//*[@id='search_mini_form']/button")
    private WebElement searchButton;
    @FindBy(how = How.XPATH, using = ".//*[@id='js-viewGrid-target']/li[6]/div/div[2]/div[3]/button[1]")
    private WebElement addToCart;
    
    
    public OrderScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public OrderScreen orderProduct(){
        searchField.sendKeys("MacBook Air");
        searchButton.click();
        addToCart.click();
        return this;   
    }
    
    @Override
    protected void isLoaded() throws Error {
        System.out.print("isLoaded");
        Assert.assertEquals(driver.getPageSource().contains("Cont client"), true);

    }

    @Override
    protected void load() {
        System.out.print("load");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
}
