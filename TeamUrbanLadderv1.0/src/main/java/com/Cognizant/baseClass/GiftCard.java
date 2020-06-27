/*********************************CREATING OBJECT REPOSITORY FOR THE GIFTCARD*************************************/
package com.Cognizant.baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Cognizant.object.TakeScreenshot;

public class GiftCard extends PageBaseClass{

	public WebDriver driver;

	// CONSTRUCTOR FOR ACCESSING THE DRIVER
	public GiftCard(WebDriver driver) {
		this.driver = driver;
	}

	// FINDING ALL THE WEBELEMENTS OF THIS PAGE USING THE LOCATORS
	@FindBy(xpath = "//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]")
	public WebElement birthday_Anniversary;
	@FindBy(xpath = "//button[@class='HuPJS'][2]")
	public WebElement fiveThousand;
	@FindBy(xpath = "//button[@class=\"_1IFIb _1fVSi action-button _1gIUf _1XfDi\"]")
	public WebElement next;
	@FindBy(id = "ip_4036288348")
	public WebElement RecName;
	@FindBy(id = "ip_137656023")
	public WebElement RecEmail;
	@FindBy(id = "ip_1082986083")
	public WebElement SenderName;
	@FindBy(id = "ip_4081352456")
	public WebElement SenderEmail;
	@FindBy(id = "ip_2121573464")
	public WebElement SenderPhone;
	@FindBy(id = "ip_582840596")
	public WebElement Message;
	@FindBy(xpath = "//*[@id=\"app-container\"]/div/main/section/section[3]/form/button")
	public WebElement confirm;

	// METHOD FOR MAKING THE ENTRIES OF GIFT CARD
	public void entriesInGiftCard() {
		birthday_Anniversary.click();
		fiveThousand.click();
		next.click();
	}

	// METHOD FOR FILLING THE DETAILS
	public void fillDetails() {
		RecName.sendKeys("Anshi");
		RecEmail.sendKeys("Anshika@gmail.com");
		SenderName.sendKeys("ppp");
		SenderEmail.sendKeys("ppp");
		SenderPhone.sendKeys("1234567890");
		Message.sendKeys("1234567890Archit");
		confirm.click();

		TakeScreenshot.takeScreenshot(driver, "Error_Message");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
