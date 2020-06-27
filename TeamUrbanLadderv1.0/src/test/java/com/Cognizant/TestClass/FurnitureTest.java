package com.Cognizant.TestClass;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.Cognizant.baseClass.BeingAtHomePage;
import com.Cognizant.baseClass.BookshelfDetails;
import com.Cognizant.baseClass.GiftCard;
import com.Cognizant.baseClass.LandingPage;
import com.Cognizant.baseClass.PageBaseClass;
import com.Cognizant.baseClass.StudyChairs;
import com.Cognizant.object.ExcelUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class FurnitureTest extends PageBaseClass {
	LandingPage landingpage;
	BookshelfDetails bookshelfdetails;
	BeingAtHomePage beingAtHome;
	StudyChairs studychairs;
	GiftCard giftCard;

	@Test
	public void UrbanLadderTest() throws IOException {

		logger = report.createTest("Get the first three bookshelf details and study chair details"
				+ " along with the details in beingAtHome section");
		
		logger.log(Status.INFO, "Opening the Browser");
		invokeBrowser("browserName");
		
		logger.log(Status.INFO, "Opening the UrbanLadder Website");
		landingpage = openApplication("websiteURLKey");
		
		landingpage.Access_login("email_address", "passkey");
		logger.log(Status.PASS, "Login Successfully");
		
		ExcelUtils ex = new ExcelUtils();
		String[] entry = ex.readExcelData();
		
		bookshelfdetails = landingpage.BookDetails(entry[0]);
		bookshelfdetails.StorageType();
		bookshelfdetails.IncludeOutOfStock();
		bookshelfdetails.priceClick();
		
		studychairs = bookshelfdetails.PrintDetails();
		logger.log(Status.PASS,"Displayed the Bookshelves for the required filters");
		
		studychairs.studyChairClick(entry[0], entry[1]);
		
		beingAtHome = studychairs.PrintDetails();
		
		logger.log(Status.PASS,"Displayed the StudyChairs for the reuired filters");
		
		beingAtHome.retrieveCollectionsData();
		beingAtHome.dataCollection();
		
		logger.log(Status.PASS,"Displayed the Details under Being At Home section");
		
		giftCard = beingAtHome.navigateToGiftCard();
		giftCard.entriesInGiftCard();
		giftCard.fillDetails();
		logger.log(Status.PASS, "Error Message Displayed");
		
		logger.pass("Displaying the error message", MediaEntityBuilder
				.createScreenCaptureFromPath("C:\\Users\\User\\TeamUrbanLadderv1.0\\Screenshots\\Error_Message.png")
				.build());
		quitBrowser();
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}

}
