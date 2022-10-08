package pageFactory;

import org.openqa.selenium.WebElement;

import automationLibrary.Driver;

public class TransactionPage {
	Driver driver;
	public TransactionPage(Driver driver){
		this.driver = driver;
	}

	public WebElement getrecentTransTable(int rowNo, int colNo) {
		return driver.findElementXpath("//table[@id='_ctl0__ctl0_Content_Main_MyTransactions']//tr["+rowNo+"]//td["+colNo+"]");
	}
}
