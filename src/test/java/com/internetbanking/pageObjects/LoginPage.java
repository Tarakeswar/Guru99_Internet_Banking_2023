package com.internetbanking.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.internetbanking.testCases.TC_Login_Test_002;
import com.internetbanking.utilities.Log;

public class LoginPage{
	
	private static final Logger log = Logger.getLogger(LoginPage.class);

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	@CacheLookup
	public WebElement textUsername;

	@FindBy(name = "password")
	@CacheLookup
	public WebElement textPassword;

	@FindBy(name = "//input[@type='submit' and @name='btnLogin']")
	@CacheLookup
	public WebElement loginbtn;
	
	@FindBy(xpath = "//a[text()='Log out']")
	@CacheLookup
	public WebElement logoutbtn;

	public void setUsername(String username) {
		textUsername.sendKeys(username);
		Log.message("enetered username");
	}

	public void setPassword(String password) {
		textUsername.sendKeys(password);
		Log.message("enetered password");
	}

	public void clickOnLoginBtn() {
		textUsername.click();
		Log.message("Click on sign in button");
	}
	
	public void clickOnLogoutBtn() {
		logoutbtn.click();
	}

}
