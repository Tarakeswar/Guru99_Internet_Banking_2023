package com.internetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.internetbanking.pageObjects.AddNewCustomer;
import com.internetbanking.pageObjects.LoginPage;

public class TC_Login_Test_003 extends BaseClass {

	private static final Logger log = Logger.getLogger(TC_Login_Test_002.class);

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUsername(userName);
		loginpage.setPassword(passWord);
		loginpage.clickOnLoginBtn();

		Thread.sleep(3000);

		AddNewCustomer customerPage = new AddNewCustomer(driver);
		customerPage.clickAddNewCustomer();
		customerPage.customerName("Tarak");
		customerPage.custgender("Male");
		customerPage.custdob("11", "05", "1990");
		customerPage.custaddress("Gothali");
		customerPage.custcity("Bhanjanagar");
		customerPage.custstate("odisha");
		customerPage.custpinno("761117");
		customerPage.custtelephoneno("9438141141");
		customerPage.custemailid(generateRandomEmail());
		customerPage.custsubmit();
		
		boolean sucessMessage=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(sucessMessage==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			takeScreenshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}

}
