/*********************************CREATING OBJECT REPOSITORY FOR THE BEINGATHOMEPAGE*************************************/
package com.Cognizant.baseClass;


import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Cognizant.object.WriteExcelData;

public class StudyChairs extends PageBaseClass{
	public WebDriver driver;
	public static String namelist[] = new String[4];
	public static String pricelist[] = new String[4];

	// CONSTRUCTOR FOR ACCESSING THE DRIVER
	public StudyChairs(WebDriver driver) {
		
		this.driver = driver;
	}

	// FINDING ALL THE WEBELEMENTS OF THIS PAGE USING THE LOCATORS
	@FindBy(xpath = "//input[@id='search']")
	public WebElement search;
	@FindBy(xpath = "//div[@class='product-title product-title-sofa-mattresses'][position()<=3]")
	public List<WebElement> results;
	@FindBy(xpath = "//div[@class='price-number'][position()<=3]")
	public List<WebElement> price;

	// METHOD FOR CLICKING THE STUDY CHAIRS
	public void studyChairClick(String data1,String data2) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int sizeofdata1 = data1.length();
		
		for(int letter=0;letter<sizeofdata1;letter++)
		{
			search.sendKeys(Keys.BACK_SPACE);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		search.sendKeys(data2);
		search.sendKeys(Keys.ENTER);
	}

	// METHOD FOR LISTING THE PRICE AND THE PRODUCT
	public BeingAtHomePage PrintDetails(){
		try {
			Thread.sleep(2000);
			String Name;
			String Price;
			int products_price;
			HashMap<Integer, String> finalmap = new HashMap<Integer, String>();
			for (int i = 0; i <=3; i++) {
				
				// Iterate and fetch product name
				Name = results.get(i).getText();
				
				// Iterate and fetch product price
				Price = price.get(i).getText();
				
				// Replace anything with other than numbers
				Price = Price.replaceAll("[^0-9]", "");
				
				// Convert to Integer
				products_price = Integer.parseInt(Price);
				
				// Add product and price in HashMap
				finalmap.put(products_price, Name);
				
				//Storing the product name and price in arrays
				namelist[i] = Name;
				pricelist[i] = Price;
			}
			
			System.out.println("Product Names and Prices of Study Chairs are:" + finalmap.toString()+"\n");
			
			}catch (StaleElementReferenceException | InterruptedException e) {
			
				System.out.println("StaleElementReferenceException caught");
		}
		
		WriteExcelData.StudyChairDetailsInExcel();
		
		return PageFactory.initElements(driver,BeingAtHomePage.class);
	}


}
