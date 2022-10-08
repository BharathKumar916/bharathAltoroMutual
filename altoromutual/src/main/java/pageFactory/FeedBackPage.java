package pageFactory;

import org.openqa.selenium.WebElement;

import automationLibrary.Driver;

public class FeedBackPage {
	Driver driver;
	public FeedBackPage(Driver driver) {
		this.driver = driver;
	}
	
	public WebElement getFeedBackName() {
		return driver.findElementXpath("//input[@name='name']");
	}
	public WebElement getFeedBackEmail() {
		return driver.findElementXpath("//input[@name='email_addr']");
	}
	public WebElement getFeedBackSubject() {
		return driver.findElementXpath("//input[@name='subject']");
	}
	public WebElement getFeedBackComment() {
		return driver.findElementXpath("//textarea[@name='comments']");
	}
	public WebElement getFeedBackSubmit() {
		return driver.findElementXpath("//input[@name='submit']");
	}
	public WebElement getThankYou() {
		return driver.findElementXpath("//div//h1[text()='Thank You']");
	}
}
