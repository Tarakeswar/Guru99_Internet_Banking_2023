package com.internetbanking.testCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.internetbanking.pageObjects.LoginPage;
import com.internetbanking.utilities.Log;
import com.internetbanking.utilities.XLUtils;

public class TC_Login_Test_002 extends BaseClass {
	
	private static final Logger logger = Logger.getLogger(TC_Login_Test_002.class);

	@Test(dataProvider = "LoginData")
	public void validateLoginWithDifferentCred(String user, String pass) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUsername(user);
		Log.message("Username is entered : "+user);
		loginpage.setPassword(pass);
		Log.message("Password is entered : "+pass);
		loginpage.clickOnLoginBtn();
		Log.message("click on the login button");
		Thread.sleep(3000);
		
		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Log.event("Login failed");
		} else {
			Assert.assertTrue(true);
			Log.event("Login Passed");
			loginpage.clickOnLogoutBtn();
			Thread.sleep(3000);
			Log.message("click on the logout button");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}

	public boolean isAlertPresent() { // method is created to check alert is present or not
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String fpath=System.getProperty("user.dir");
		String path = fpath+"./src/test/java/com/internetbanking/testData/LoginData.xlsx";
		int rowNum = XLUtils.getRowCount(path, "Sheet1");
		int ColNum = XLUtils.getCellCount(path, "Sheet1", 1);

		String[][] logindata = new String[rowNum][ColNum];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < ColNum; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
