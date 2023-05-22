package org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BaseClass{
	
	
	//1. Non - Para Constructor
	public LoginPojo() {
		PageFactory.initElements(driver, this);
	}
	
	// AND
	@CacheLookup
	@FindBys({
		@FindBy(id="email"),
		@FindBy(xpath="//input[@type='text']")
	})
	private WebElement txtUser;
	
	
	// OR
	@CacheLookup
	@FindAll({
		@FindBy(id="Java"),
		@FindBy(xpath="//input[@type='password']")
	})
	private WebElement txtPass;
	
	@CacheLookup
	@FindBy(xpath="//button[@name='login']")
	private WebElement btnLogin;
	
	

	public WebElement getTxtUser() {
		return txtUser;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	
	
	
	

}
