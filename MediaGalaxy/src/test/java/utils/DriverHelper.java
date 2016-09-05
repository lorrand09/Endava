package utils;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class DriverHelper {

    static String browser = ConfigFileHelper.INSTANCE.readProperty("browser");
    private static WebDriver driver = null;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(DriverHelper.class);

    private DriverHelper() {

    }

    public static WebDriver getDriver() {
        if (null == driver) {

            if (null != browser) {
                if (browser.equals("firefox")) {
                    LOG.info("Creating Firefox driver");
                    driver = new FirefoxDriver();
                    LOG.info("Firefox driver created");

                }
                if (browser.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
                    driver = new ChromeDriver();
                }
            } else {
                LOG.error("Please enter -Dbrowser variable");
                Assert.fail("Please enter -Dbrowser= variable");
            }

        }
        return driver;

    }

    public static void closeBrowser() {
        if (null != driver) {
            LOG.info("Inchid driverul");
            driver.quit();
        }
    }

}
