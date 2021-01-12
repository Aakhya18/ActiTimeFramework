package com.actitime.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {

	/**
	 * 
	 * @param value
	 * @return
	 * @throws IOException
	 */
	public  String GetProperty(String value) throws IOException {
		FileInputStream fin = new FileInputStream("./data/customer.property");
		Properties p = new Properties();
		p.load(fin);
		String v = p.getProperty(value);
		return v;
	}

	/**
	 * 
	 * @param status
	 * @param sheet
	 * @param row
	 * @param cell
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void SetPropertyExcel(String status, String sheet, int row, int cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./data/data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(status);// 1 5 Customer
		FileOutputStream fos = new FileOutputStream("./data/data.xlsx");
		wb.write(fos);
		wb.close();
	}

	public String getPropertyExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./data/data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

}
