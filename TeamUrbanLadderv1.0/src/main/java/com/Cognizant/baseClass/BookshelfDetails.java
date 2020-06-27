/*********************************CREATING OBJECT REPOSITORY FOR THE BOOKSHELFDETAILS*************************************/
package com.Cognizant.baseClass;


import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Cognizant.object.WriteExcelData;


public class BookshelfDetails extends PageBaseClass {

	public WebDriver driver;
	public static String productname[] = new String[4];
	public static String productprice[] = new String[4];

	// CONSTRUCTOR FOR ACCESSING THE DRIVER
	public BookshelfDetails(WebDriver driver) {
		this.driver = driver;
	}

	// FINDING ALL THE WEBELEMENTS OF THIS PAGE USING THE LOCATORS
	@FindBy(xpath = "//li[@data-group='price']")
	public WebElement price;
	@FindBy(xpath = "//div[@class='noUi-handle noUi-handle-upper']")
	public WebElement high;
	@FindBy(xpath = "//li[@data-group=\"storage type\"]")
	public WebElement basic;
	@FindBy(id = "filters_storage_type_Open")
	public WebElement storage;
	@FindBy(id = "filters_availability_In_Stock_Only")
	public WebElement OutOfStock;
	@FindBy(xpath = "//span[@class='name'][position()<=3]")
	public List<WebElement> list_of_products;
	@FindBy(xpath = "//div[@class='price-number'][position()<=3]")
	public List<WebElement> list_of_products_price;

	// METHOD FOR DRAGGING THE PRICE SLIDER
	public void priceClick() {

		Actions action = new Actions(driver);
		action.moveToElement(price).build().perform();

		Actions act = new Actions(driver);
		act.dragAndDropBy(high, -205, 0).build().perform();

	}

	// METHOD FOR SELECTING THE STORAGE TYPE
	public void StorageType() {

		Actions action = new Actions(driver);
		action.moveToElement(basic).build().perform();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(storage));

		storage.click();

	}

	// METHOD FOR CLICKING ON OUTOFSTOCK
	public void IncludeOutOfStock() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OutOfStock.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// METHOD FOR SCROLLING DOWN THE PAGE
	public void scrolldown() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// METHOD FOR PRINTING THE DETAILS OF PRODUCTS AND PRICES
	public StudyChairs PrintDetails() {

		// Use of HashMap to store Products and Their prices(after conversion to Integer)
		try {
			Thread.sleep(5000);
			String product_name;
			String product_price;
			int int_product_price;

			HashMap<Integer, String> map_final_products = new HashMap<Integer, String>();

			for (int i = 0; i <3; i++) {
				// Iterate and fetch product name
				product_name = list_of_products.get(i).getText();

				// Iterate and fetch product price
				product_price = list_of_products_price.get(i).getText();

				// Replace anything with other than numbers
				product_price = product_price.replaceAll("[^0-9]", "");

				// Convert to Integer
				int_product_price = Integer.parseInt(product_price);

				// Add product and price in HashMap
				map_final_products.put(int_product_price, product_name);

				//Storing the product name and price in arrays
				productname[i] = product_name;
				productprice[i] = product_price;
			}

			System.out.println("Product Names and prices of Bookshelf are:"+ map_final_products.toString() + "\n");

		}catch (StaleElementReferenceException | InterruptedException e) {

			System.out.println("StaleElementReferenceException caught");

		}

		//Calling The BookshelfDetailsInExcel() to write the result in the excel file
		WriteExcelData.BookshelfDetailsInExcel();

		return PageFactory.initElements(driver, StudyChairs.class);
	}


	
	

}
