package automationLibrary;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	public WebDriver driver;
	public Driver() {
		System.out.println("Chrome");
		this.driver = chromeDriver();
		this.driver.get("http://testfire.net/index.jsp");
	}
	
	public WebDriver chromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		return driver;
	}

	public WebElement findElementXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	public void quitBrowser() {
		 driver.quit();
	}
}