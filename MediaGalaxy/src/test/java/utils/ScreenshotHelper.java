package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public enum ScreenshotHelper {
	INSTANCE;
	public void getScreenshot(String ssName) throws Exception {
		  File scrFile = ((TakesScreenshot) DriverHelper.getDriver()).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/screenshots/" + ssName + ".png"));
		 }
}
