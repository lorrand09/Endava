package screens;

import java.security.SecureRandom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountScreen {
    private WebDriver driver;
    String word = randomString(7);
    private static String URL = "http://www.mediagalaxy.ro/customer/account/create/";
    private static String TITLE = "Vreau un cont nou";

    @FindBy(id = ".//*[@id='register_prenume']")
    private WebElement prenume;
    @FindBy(id = ".//*[@id='register_nume']")
    private WebElement nume;
    @FindBy(id = ".//*[@id='register_telefon']")
    private WebElement telefon;
    @FindBy(id = ".//*[@id='register_email']")
    private WebElement email;
    @FindBy(id = ".//*[@id='register_pass']")
    private WebElement password;
    @FindBy(id = ".//*[@id='pass2']")
    private WebElement confirmpassword;
    @FindBy(id = ".//*[@id='form-validate']/div[7]/label")
    private WebElement newsletter;
    @FindBy(id = ".//*[@id='form-validate']/div[8]/label")
    private WebElement terms;
    @FindBy(id = "  .//*[@id='form-validate']/input[3]")
    private WebElement create;

    public CreateAccountScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillFirstName() {
        prenume.sendKeys("Kevin");
    }

    public void fillLastName() {
        nume.sendKeys("Jones");
    }

    public void fillPhone() {
        telefon.sendKeys("07" + System.currentTimeMillis());
    }

    public void fillEmail() {
        email.sendKeys(randomString(7) + "@yahoo.com");
    }

    public void fillPassword() {
        password.sendKeys(word);
    }

    public void fillConfirmPassword() {
        confirmpassword.sendKeys(word);
    }

    public void checkNewsletter() {
        newsletter.click();
    }

    public void checkTerms() {
        terms.click();
    }

    public RegistrationCompleteScreen Create() {
        create.click();
        return new RegistrationCompleteScreen(driver);
    }

    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    
    protected void isLoaded() throws Error {
        System.out.println("page is loaded");
        Assert.assertEquals("Title should be: " + TITLE, driver.getTitle());
    }

    protected void load() {
        System.out.print("load");
        driver.get(URL);

    }

    public CreateAccountScreen get() {
        // TODO Auto-generated method stub
        return null;
    }
}
