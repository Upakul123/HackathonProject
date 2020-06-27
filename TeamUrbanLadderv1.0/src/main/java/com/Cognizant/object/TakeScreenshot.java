/*********************************CLASS FOR TAKING THE SCREENSHOT WHEREVER REQUIRED*************************************/
package com.Cognizant.object;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {

	public static void takeScreenshot(WebDriver driver, String ScreenName) {
		try {
			// Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot = (TakesScreenshot) driver;
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(SrcFile, new File("./Screenshots/" + ScreenName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
