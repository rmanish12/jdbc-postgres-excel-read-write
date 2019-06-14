package com.postgres;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	private static final String FILE_PATH = "C:\\Users\\manish.ranjan\\Desktop\\TestFile.xlsx";
	
	void readExcelFile() {
		FileInputStream fis = null;
		String name;
		int maths, science, english;
		
		DBConnect db = new DBConnect();
		
		try {
			fis = new FileInputStream(FILE_PATH);
			
			Workbook workbook = new XSSFWorkbook(fis);
			
			Sheet sheet = workbook.getSheetAt(0);			
			//System.out.println(sheet.getLastRowNum());
			
			for(int i=1; i<=sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				
				name = row.getCell(0).toString();
				maths = Integer.parseInt(String.format("%.0f", Float.parseFloat(row.getCell(1).toString())));
				science = Integer.parseInt(String.format("%.0f", Float.parseFloat(row.getCell(2).toString())));
				english = Integer.parseInt(String.format("%.0f", Float.parseFloat(row.getCell(3).toString())));
				
				db.writeToDB(name, maths, science, english);
				//System.out.println(name + " " + maths + " " + science + " " + english);
			}
			
			workbook.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
