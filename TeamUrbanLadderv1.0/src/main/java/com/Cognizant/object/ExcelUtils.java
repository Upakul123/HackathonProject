/*********************************CLASS FOR READING THE DETAILS FROM AN EXCEL SHEET*************************************/
package com.Cognizant.object;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public String Data[] = new String[2];

	// METHOD FOR READING THE DATAS FROM THE EXCEL FILE NAMED 'DATA'
	public String[] readExcelData() throws IOException {
		FileInputStream readFile = new FileInputStream("Data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(readFile);
		XSSFSheet sht = wb.getSheet("DataSheet");
		XSSFRow row1 = sht.getRow(0);
		for (int i = 0; i < 2; i++) {
			XSSFCell c1 = row1.getCell(i);
			Data[i] = c1.toString();
		}
		wb.close();
		return Data;
	}

}
