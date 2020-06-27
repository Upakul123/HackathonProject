/*********************************CREATING OBJECT REPOSITORY FOR THE LANDING PAGE*************************************/

package com.Cognizant.baseClass;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends PageBaseClass {
	public WebDriver driver;
	public Properties prop;

	// CONSTRUCTOR FOR ACCESSING THE DRIVER
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	// FINDING ALL THE WEBELEMENTS OF THIS PAGE USING THE LOCATORS
	@FindBy(xpath = "//a[@class='login-link link-color']")
	public WebElement loginLink;
	@FindBy(xpath = "//input[@class='email required input_authentication']")
	public WebElement emailid;
	@FindBy(xpath = "//input[@class='required input_authentication']")
	public WebElement password;
	@FindBy(xpath = "//input[@class='button primary']")
	public WebElement LogInButn;
	@FindBy(id = "search")
	public WebElement Search;

	// METHOD FOR ADDING THE LOGIN DETAILS
	public void Access_login(String email_address, String passkey) {
		// ACCESSING THE DATAS STORED IN THE CONFIG.PROPERTIES FILE
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir")
							+ "\\PropertiesFolder\\propFile\\config.properties");
			prop.load(file);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		loginLink.click();
		
		emailid.sendKeys(prop.getProperty(email_address));
		
		password.sendKeys(prop.getProperty(passkey));
		
		LogInButn.click();

	}

	//METHOD FOR SEARCHING ON THE SEARCH BAR
	public BookshelfDetails BookDetails(String data) {

		Search.sendKeys(data);
		
		Search.sendKeys(Keys.ENTER);

		return PageFactory.initElements(driver, BookshelfDetails.class);

	}

}
