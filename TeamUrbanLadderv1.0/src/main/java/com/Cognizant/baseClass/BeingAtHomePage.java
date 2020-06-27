/*********************************CREATING OBJECT REPOSITORY FOR THE BEINGATHOMEPAGE*************************************/
package com.Cognizant.baseClass;




import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Cognizant.object.WriteExcelData;

public class BeingAtHomePage extends PageBaseClass {
	public WebDriver driver;
	
	public static String details[] = new String[14];
	
	int i = 0;

	// CONSTRUCTOR FOR ACCESSING THE DRIVER
	public BeingAtHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// FINDING ALL THE WEBELEMENTS OF THIS PAGE USING THE LOCATORS
	@FindBy(xpath = "//span[contains(text(),'Collections')]")
	public WebElement collections;
	@FindBy(xpath = "//a[contains(text(),'Being At Home')]")
	public WebElement BeingAtHome;
	@FindBy(xpath = "//div[@class='col-xs-12 no-padding col-lg-6 col-sm-6'][position()<=13]")
	public List<WebElement> detailsofBeingAtHome;
	@FindBy(xpath = "(//a[@class='featuredLinksBar__link'])[4]")
	public WebElement giftCard;

	// METHOD FOR NAVIGATING TO THE BEING AT HOME PAGE
	public void retrieveCollectionsData() {

		Actions action = new Actions(driver);
	
		action.moveToElement(collections).build().perform();
		
		BeingAtHome.click();

	}

	// METHOD FOR STORING THE DETAILS INSIDE AN ARRAY LIST
	public void dataCollection() {

		System.out.println("********************* Details under Being at Home ***************************"+"\n");
		for (WebElement AtHome : detailsofBeingAtHome) {
		
			String listofdetails = AtHome.getText();
			
			if (!listofdetails.isEmpty())
				try {
					{
						details[i] = AtHome.getText();
						System.out.println(details[i]);
						i++;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
	
		WriteExcelData.BeingAtHomePageInExcel();
		
		
	}
		

	// METHOD FOR NAVIGATING TO GIFT CARD PAGE
	public GiftCard navigateToGiftCard() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		giftCard.click();
		
		return PageFactory.initElements(driver, GiftCard.class);
	}

}
