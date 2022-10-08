package pageFactory;
import org.openqa.selenium.WebElement;

import automationLibrary.Driver;

public class LoginPage {
	Driver driver;
	
	public LoginPage(Driver driver) {
		this.driver = driver;
	}
	
	public WebElement getLoginFailedAlert() {
		return driver.findElementXpath("//span[@id='_ctl0__ctl0_Content_Main_message']");
	}
	public WebElement getHelloAdmin() {
		return driver.findElementXpath("//tbody//tr//td//div//h1");
	}
	
	
	public void loginToAltoroMutual(String userName, String password) {
//		driver = new Driver();
		driver.findElementXpath("//*[text()='Sign In']").click();
		driver.findElementXpath("//input[@id='uid']").clear();
		driver.findElementXpath("//input[@id='uid']").sendKeys(userName);
		driver.findElementXpath("//input[@id='passw']").clear();
		driver.findElementXpath("//input[@id='passw']").sendKeys(password);
		driver.findElementXpath("//input[@name='btnSubmit']").click();		
	}
}