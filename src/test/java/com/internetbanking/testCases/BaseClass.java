package com.internetbanking.testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.internetbanking.utilities.Log;
import com.internetbanking.utilities.PropertiesReader;

public class BaseClass {

	PropertiesReader readConfig = PropertiesReader.getInstance();
	private static final Logger log = Logger.getLogger(BaseClass.class);

	public String baseURL = readConfig.getProperty("baseURL");
	public String userName = readConfig.getProperty("username");
	public String passWord = readConfig.getProperty("password");
	public WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) throws FileNotFoundException, IOException {
		
		if(br.equals("chrome")) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		}
		else if(br.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			driver= new InternetExplorerDriver();
		}
		Log.testCaseInfo("login banking application test started ");
		driver.get(baseURL);
		Log.message("open the browser");
		driver.manage().window().maximize();
		Log.message("Browser is maxmized");
	}

	@AfterClass
	public void tearDown() {
		//driver.close();
		Log.endTestCase();
	}
	
	public void takeScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
	}
	
	public static String generateRandomEmail() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		String email = generatedstring + "@testdata.com";
		return email;
	}

}
