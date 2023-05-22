package org.wipro;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.utilities.BaseClass;
import org.utilities.LoginPojo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch extends BaseClass{
	public static void main(String[] args) throws IOException {
		
		launchChrome();
		loadUrl("https://www.facebook.com");
		winMax();
		printTitle();
		printCurrentUrl();
		
		
		LoginPojo l= new LoginPojo();
		fill(l.getTxtUser(), "Greens");
		
		driver.navigate().refresh();
		
		
		LoginPojo li = new LoginPojo();
		fill(li.getTxtUser(), "Greens tech");
		
		
	}

}
