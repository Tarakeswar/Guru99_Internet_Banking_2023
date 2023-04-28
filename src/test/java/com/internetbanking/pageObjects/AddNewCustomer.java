package com.internetbanking.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
	private static final Logger log = Logger.getLogger(LoginPage.class);

	public WebDriver driver;

	public AddNewCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	public WebElement addNewCustomerlink;
	
	@FindBy(xpath = "//td[text()='Customer Name']/following-sibling::td/input")
	@CacheLookup
	public WebElement txtcustomername;
	
	@FindBy(xpath = "//td[text()='Gender']/following-sibling::td/input[1]")
	@CacheLookup
	public WebElement male;
	
	@FindBy(xpath = "//td[text()='Gender']/following-sibling::td/input[2]")
	@CacheLookup
	public WebElement female;
	
	@FindBy(id = "dob")
	@CacheLookup
	public WebElement txtdob;
	
	@FindBy(xpath = "//td[text()='Address']/following-sibling::td/textarea")
	@CacheLookup
	public WebElement txtaddress;
	
	@FindBy(xpath = "//td[text()='City']/following-sibling::td/input")
	@CacheLookup
	public WebElement txtcity;
	
	@FindBy(xpath = "///td[text()='State']/following-sibling::td/input")
	@CacheLookup
	public WebElement txtstate;
	
	@FindBy(xpath = "//td[text()='PIN']/following-sibling::td/input")
	@CacheLookup
	public WebElement txtpinnum;
	
	@FindBy(xpath = "//td[text()='Telephone Number']/following-sibling::td/input")
	@CacheLookup
	public WebElement txttelephone;
	
	@FindBy(xpath = "//td[text()='E-mail']/following-sibling::td/input")
	@CacheLookup
	public WebElement txtemailid;
	
	@FindBy(name = "sub")
	@CacheLookup
	public WebElement submitBtn;
	
	
	public void clickAddNewCustomer() {
		addNewCustomerlink.click();
			
	}

	public void customerName(String cname) {
		txtcustomername.sendKeys(cname);
		
	}

	public void custgender(String cgender) {
		male.click();
	}

	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}

	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtpinnum.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		txttelephone.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}

	public void custsubmit() {
		submitBtn.click();
	}
	
	
}
