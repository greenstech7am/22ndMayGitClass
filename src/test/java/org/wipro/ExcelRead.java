package org.wipro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException {

		// 1. Declare your file Location
		File f = new File("C:\\Kannan\\EclipseProjects\\FrameworkBatch5thMay\\target\\TestData\\2ndMayBatch.xlsx");

		// 2. Read the File
		FileInputStream fin = new FileInputStream(f);

		// 3. Type of Workbook
		Workbook w = new XSSFWorkbook(fin);

		// 4. Get the sheet
		Sheet s = w.getSheet("greens");
		
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			
			Row row = s.getRow(i);
			
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				
				Cell c = row.getCell(j);
				
				int cellType = c.getCellType();
				
				if (cellType==1) {
					String value = c.getStringCellValue();
					
					if (value.equals("Greens")) {
						c.setCellValue("Black");
						FileOutputStream fout =new FileOutputStream(f);
						w.write(fout);
						System.out.println("Success");
						
					}
					
				}
				
			}
			
		}

		

	}

}
