package pageFactory;

import org.openqa.selenium.WebElement;

import automationLibrary.Driver;

public class TransferPage {
	Driver driver;
	
	public TransferPage(Driver driver) {
		this.driver = driver;
	}
	
//	Tranasfer Fund
	public WebElement getFromAccDD() {
		return driver.findElementXpath("//select[@id='fromAccount']");
	}	
	public WebElement getToAccDD() {
		return driver.findElementXpath("//select[@id='toAccount']");
	}
	public WebElement getAmountToTransfer() {
		return driver.findElementXpath("//input[@id='transferAmount']");
	}
	public WebElement getTransMoneyButton() {
		return driver.findElementXpath("//input[@name='transfer']");
	} 
	public WebElement getTransDetailMSG() {
		return driver.findElementXpath("//span[@id='_ctl0__ctl0_Content_Main_postResp']//span");
	}
}
