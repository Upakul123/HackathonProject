/*********************************CLASS FOR ADDING THE DETAILS INSIDE AN EXCEL SHEET*************************************/
package com.Cognizant.object;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Cognizant.baseClass.BeingAtHomePage;
import com.Cognizant.baseClass.BookshelfDetails;
import com.Cognizant.baseClass.StudyChairs;

public class WriteExcelData {

	public static String[] nameofBookshelf = new String[4];
	public static String[] priceofBookshelf = new String[4];
	public static String[] nameofStudyChair = new String[4];
	public static String[] priceofStudyChair = new String[4];
	public static String[] detailsofBeingAtHome = new String[14];
	static XSSFWorkbook workbook = new XSSFWorkbook();
	
	//METHOD FOR ADDING THE DETAILS OF BOOKSHELF UNDER A SHEET 
	public static void BookshelfDetailsInExcel()
	{
		for(int i=0;i<=3;i++)
		{
			nameofBookshelf[i] = BookshelfDetails.productname[i];
			priceofBookshelf[i] = BookshelfDetails.productprice[i];
		}
		
		
		XSSFSheet sheet = workbook.createSheet("DetailsofBookShelves");
		Row row1 = sheet.createRow(0);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("Details of Book Shelves");
		int rownum = 1;
		for (int j = 0; j <= 3; j++) {
			Row row2 = sheet.createRow(rownum);
			Cell cell2 = row2.createCell(0);
			cell2.setCellValue(nameofBookshelf[j]);
			Cell cell3 = row2.createCell(1);
			cell3.setCellValue(priceofBookshelf[j]);
			rownum++;
		}

		try {
			FileOutputStream writeFile = new FileOutputStream("WriteDetails.xlsx");
			workbook.write(writeFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//METHOD FOR ADDING THE DETAILS OF STUDYCHAIRS UNDER A SHEET
	public static void StudyChairDetailsInExcel()
	{
		
		for(int i=0;i<=3;i++)
		{
			nameofStudyChair[i] = StudyChairs.namelist[i];
			priceofStudyChair[i] = StudyChairs.pricelist[i];
		}
	
		XSSFSheet sheet = workbook.createSheet("DetailsofStudyChairs");
		Row row1 = sheet.createRow(0);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("Details of Study Chairs");
		int rownum = 1;
		for (int j = 0; j <=3; j++) {
			Row row2 = sheet.createRow(rownum);
			Cell cell2 = row2.createCell(0);
			cell2.setCellValue(nameofStudyChair[j]);
			Cell cell3 = row2.createCell(1);
			cell3.setCellValue(priceofStudyChair[j]);
			rownum++;
		}
		
		try {
			FileOutputStream writeFile = new FileOutputStream("WriteDetails.xlsx");
			workbook.write(writeFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//METHOD FOR ADDING THE DETAILS OF BEINGATHOME UNDER A SHEET
	public static void BeingAtHomePageInExcel()
	{
		for(int i=0;i<=13;i++)
		{
			detailsofBeingAtHome[i] = BeingAtHomePage.details[i];
		}

		XSSFSheet sheet = workbook.createSheet("DetailsofBeingAtHome");
		Row row1 = sheet.createRow(0);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("Details of Being At Home");
		int rownum = 1;
		for (int j = 0; j <=13; j++) {
			Row row2 = sheet.createRow(rownum);
			Cell cell2 = row2.createCell(0);
			cell2.setCellValue(detailsofBeingAtHome[j]);
			rownum++;
		}
		FileOutputStream writeFile;
		try {
			writeFile = new FileOutputStream("WriteDetails.xlsx");
			workbook.write(writeFile);
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
