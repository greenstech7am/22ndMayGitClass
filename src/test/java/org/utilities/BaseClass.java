package org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	// 1.
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// 2
	public static void loadUrl(String url) {
		driver.get(url);
	}

	// 3.
	public static void winMax() {
		driver.manage().window().maximize();
	}

	// 4.
	public static void printTitle() {
		System.out.println(driver.getTitle());

	}

	// 5.
	public static void printCurrentUrl() {
		System.out.println(driver.getCurrentUrl());

	}

	// 6
	public static void fill(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	// 7.
	public static void btnClick(WebElement ele) {
		ele.click();

	}

	// 8.
	public static void chromeClose() {
		driver.close();

	}

	// 9.
	public static String getData(int rowNumber, int cellNumber) throws IOException {
		// 1. Declare your file Location
		File f = new File("C:\\Kannan\\EclipseProjects\\FrameworkBatch5thMay\\target\\TestData\\2ndMayBatch.xlsx");

		// 2. Read the File
		FileInputStream fin = new FileInputStream(f);

		// 3. Type of Workbook
		Workbook w = new XSSFWorkbook(fin);

		// 4. Get the sheet
		Sheet s = w.getSheet("greens");

		// 5. Get the row
		Row row = s.getRow(rowNumber);

		// 6. get the cell
		Cell c = row.getCell(cellNumber);

		int cellType = c.getCellType();
		String value;
		if (cellType == 1) {
			value = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {

			Date d = c.getDateCellValue();

			SimpleDateFormat sim = new SimpleDateFormat("dd,MMMM,yyyy");
			value = sim.format(d);
		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			value = String.valueOf(l);
		}
		
		return value;
		
		

	}

}
