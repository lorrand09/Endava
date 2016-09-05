package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public enum WaitHelper {
	INSTANCE;
	private WebDriver driver = DriverHelper.getDriver();

	public void waitForElementVisibility(By by, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(by));
	}
}
