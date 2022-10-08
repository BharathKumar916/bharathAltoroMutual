package pageFactory;
import org.openqa.selenium.WebElement;
import automationLibrary.Driver;

public class MainPage {
    Driver driver;
    
	public MainPage(Driver driver) {
		this.driver = driver;		
	}

	public WebElement getViewAccSummary() {
		return driver.findElementXpath("//li//a[@id='MenuHyperLink1']");
	} 
	public WebElement getViewAccDetailsDD() {
		return driver.findElementXpath("//select[@name='listAccounts']");
	}
	public WebElement getViewAccDetailsGO() {
		return driver.findElementXpath("//input[@id='btnGetAccount']");
	}
	public WebElement getAvailableBal() {
		return driver.findElementXpath("//tbody//tr//td[contains(text(), 'Available bala')]//following-sibling::*");
	}
	public WebElement getTransferFund() {
		return driver.findElementXpath("//a[text()='Transfer Funds']");
	}
// View Recent Transaction
	public WebElement getViewRecTrans() {
		return driver.findElementXpath("//a[text()='View Recent Transactions']");
	}
//	Contact US
	public WebElement getContactUSBut() {
		return driver.findElementXpath("//a[@id='HyperLink3']");
	}
	public WebElement getOnlineForm() {
		return driver.findElementXpath("//a[text()='online form']");
	}
	
	public WebElement getSignOff() {
		return driver.findElementXpath("//a//font[text()='Sign Off']");
	}
	
}

