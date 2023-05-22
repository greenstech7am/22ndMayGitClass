package org.wipro;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	
	public static void main(String[] args) throws IOException {
		
		
		
		//1. File location	
		File f = new File("C:\\Kannan\\EclipseProjects\\FrameworkBatch5thMay\\target\\TestData\\GreensTech.xlsx");
		
		// Create a excel sheet
		boolean a = f.createNewFile();
		System.out.println(a);
		
		
		//2. Mention the workbook
		Workbook w = new XSSFWorkbook();
		
		//3. Create the sheet
		Sheet s = w.createSheet("ABC");
		
		//4. Create the row
		Row r = s.createRow(0);
		
		//5. Create the cell
		Cell c = r.createCell(0);
		
		//6. Pass the value
		c.setCellValue("Java");
		
		FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
		
		System.out.println("Success");
		
		
	}

}
