package screens;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.Cont;

public class RegisterScreen extends LoadableComponent<RegisterScreen> {

    private WebDriver driver;

    @FindBy(id = "register_prenume")
    private WebElement prenume;
    @FindBy(id = "register_nume")
    private WebElement nume;
    @FindBy(id = "register_telefon")
    private WebElement telefon;
    @FindBy(id = "register_email")
    private WebElement email;
    @FindBy(id = "register_pass")
    private WebElement password;
    @FindBy(id = "register_pass2")
    private WebElement confirmpassword;
    @FindBy(xpath = ".//*[@id='form-validate']//label[@class ='icheck-label icheckbox'][@for='is_subscribed']")
    private WebElement newsletter;
    @FindBy(xpath = ".//*[@id='form-validate']//label[@for='terms-and-conditions']")
    private WebElement terms;
    @FindBy(how = How.XPATH, using = ".//*[@id='form-validate']/input[@class='Button Button--small Button-primary']")
    private WebElement create;

    public RegisterScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CompleteRegistrationScreen fillInForm(Cont cont) {

        if ((null != cont.getPrenume())) {
            prenume.sendKeys(cont.getPrenume());
        }
        if ((null != cont.getNume())) {
            nume.sendKeys(cont.getNume());
        }
        if (null != cont.getTelefon()) {
            telefon.sendKeys(cont.getTelefon());
        }
        if (null != cont.getEmail()) {
            email.sendKeys(cont.getEmail());
        }
        if (null != cont.getParola()) {
            password.sendKeys(cont.getParola());
        }
        if (null != cont.getConfirmParola()) {
            confirmpassword.sendKeys(cont.getConfirmParola());
        }

        newsletter.click();
        terms.click();
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        create.click();

        return new CompleteRegistrationScreen(driver).get();
    }

    @Override
    protected void isLoaded() throws Error {
        System.out.print("isLoaded");
        Assert.assertEquals(driver.getPageSource().contains("Vreau un cont nou"), true);

    }

    @Override
    protected void load() {
        System.out.print("load");
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

}
