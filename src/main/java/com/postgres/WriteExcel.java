package com.postgres;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	private static final String FILE_PATH = "C:\\Users\\manish.ranjan\\Desktop\\WriteExcel.xlsx";
	
	static Workbook workbook = null;
	static Sheet studentSheet = null;
	static FileOutputStream fos = null;
	
	static int rowIndex = 1;
	
	public static void createSheet() {
		workbook = new XSSFWorkbook();
		studentSheet = workbook.createSheet("Marks");		
		
		Row row = studentSheet.createRow(0);
		int cellIndex = 0;
		row.createCell(cellIndex++).setCellValue("ID");
		row.createCell(cellIndex++).setCellValue("Name");
		row.createCell(cellIndex++).setCellValue("Maths");
		row.createCell(cellIndex++).setCellValue("Science");
		row.createCell(cellIndex++).setCellValue("English");
		
		try {
			fos = new FileOutputStream(FILE_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void writeExcelFile(int id, String name, int maths, int science, int english) {
		
		System.out.println(id + " " + name + " " + maths + " " + science + " " + english);
		
		Row row = studentSheet.createRow(rowIndex++);
		
		int cellIndex = 0;
		row.createCell(cellIndex++).setCellValue(id);
		row.createCell(cellIndex++).setCellValue(name);
		row.createCell(cellIndex++).setCellValue(maths);
		row.createCell(cellIndex++).setCellValue(science);
		row.createCell(cellIndex++).setCellValue(english);	
		
	}
	
	static void doneWriting() {
		try {
			workbook.write(fos);
			fos.close();
			
			System.out.println("Record written");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
