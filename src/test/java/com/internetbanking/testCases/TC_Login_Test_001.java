package com.internetbanking.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.internetbanking.pageObjects.LoginPage;
import com.internetbanking.utilities.Log;

public class TC_Login_Test_001 extends BaseClass {

	private static final Logger log = Logger.getLogger(TC_Login_Test_001.class);

	@Test
	public void loginTest() throws InterruptedException, IOException {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUsername(userName);
		Log.message("username is entered");
		loginpage.setPassword(passWord);
		Log.message("password is entered");
		loginpage.clickOnLoginBtn();
		Log.message("click on the signin button");
		Thread.sleep(3000);

		if (driver.getTitle().equals("GTPL Bank Home Page")) {
			Assert.assertTrue(true);
			Log.message("login test passed");
		} else {
			takeScreenshot(driver, userName);
			Assert.assertTrue(false);
			Log.message("login test failed");
		}
		
	}

	

}
