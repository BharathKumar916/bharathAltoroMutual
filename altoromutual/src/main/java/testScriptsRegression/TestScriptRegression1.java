package testScriptsRegression;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import automationLibrary.Driver;
import pageFactory.FeedBackPage;
import pageFactory.LoginPage;
import pageFactory.MainPage;
import pageFactory.TransactionPage;
import pageFactory.TransferPage;
import testDatas.TestData;

public class TestScriptRegression1{
	Driver driver;
	SoftAssert asserts;
	LoginPage loginPage;
	MainPage mainPage;
	FeedBackPage feedback;
	TransferPage transfer;
	TransactionPage transaction;
	
	@BeforeClass
	public void preCondition() {
		driver = new Driver();
		asserts = new SoftAssert();
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		feedback = new FeedBackPage(driver);
		transfer = new TransferPage(driver);
		transaction = new TransactionPage(driver);
	}
	
	@Test
	public void verifyAndValidation() throws Exception {
	
		loginPage.loginToAltoroMutual(TestData.inValidUserName, TestData.inValidPassword);
		System.out.println("Logged in As :" + TestData.inValidUserName);
		asserts.assertTrue(loginPage.getLoginFailedAlert().isDisplayed());
		asserts.assertAll();
		loginPage.loginToAltoroMutual(TestData.validUserName, TestData.validPassword);
		System.out.println("Logged in As :" + TestData.validUserName);
		asserts.assertTrue(loginPage.getHelloAdmin().isDisplayed());
		asserts.assertAll();
		System.out.println("Logged In Succesfully With Valid Credentials");
		mainPage.getViewAccSummary().click();
		System.out.println("View Account Button Clicked");
		Select viewAccDD = new Select(mainPage.getViewAccDetailsDD());
		viewAccDD.selectByVisibleText(TestData.accViewDD);
		mainPage.getViewAccDetailsGO().click();
		
		try {			
		int avaBalance = Integer.parseInt(mainPage.getAvailableBal().getText());
		System.out.println("Available Balance " + avaBalance);
		asserts.assertTrue(avaBalance > Integer.parseInt(TestData.amount));
		} catch(Exception e) {
			
		}
		asserts.assertAll();
		mainPage.getTransferFund().click();
		System.out.println("Transfer Fund Clicked");
		Select fromAccDD = new Select(transfer.getFromAccDD());
		fromAccDD.selectByValue(TestData.fromAcc);
		Select toAccDD = new Select(transfer.getToAccDD());
		toAccDD.selectByValue(TestData.toAcc);
		transfer.getAmountToTransfer().click();
		transfer.getAmountToTransfer().sendKeys(TestData.amount);
		transfer.getTransMoneyButton().click();
		String actTransMSG = transfer.getTransDetailMSG().getText();
		asserts.assertTrue(actTransMSG.contains(TestData.amount));
		asserts.assertAll();
		mainPage.getViewRecTrans().click();
		asserts.assertEquals(transaction.getrecentTransTable(2, 3).getText(), TestData.toAcc);
		asserts.assertEquals(transaction.getrecentTransTable(2, 4).getText(), TestData.deposite);
		asserts.assertTrue(transaction.getrecentTransTable(2, 5).getText().contains("$"+ TestData.amount));
		asserts.assertEquals(transaction.getrecentTransTable(3, 3).getText(), TestData.fromAcc);
		asserts.assertEquals(transaction.getrecentTransTable(3, 4).getText(), TestData.withDraw);
		asserts.assertTrue(transaction.getrecentTransTable(3, 5).getText().contains("-$"+ TestData.amount));
		asserts.assertAll();
		System.out.println("Transaction Records Found As Expected");
		mainPage.getContactUSBut().click();
		System.out.println("Clicked Contact Us");
		mainPage.getOnlineForm().click();
		System.out.println("Clicked Online Form");
		feedback.getFeedBackName().sendKeys(TestData.name);
		feedback.getFeedBackEmail().sendKeys(TestData.email);
		feedback.getFeedBackSubject().sendKeys(TestData.subject);
		feedback.getFeedBackComment().sendKeys(TestData.comment);
		feedback.getFeedBackSubmit().click();
		asserts.assertTrue(feedback.getThankYou().isDisplayed());
		asserts.assertAll();
		System.out.println("Thank you Displaying As Expected..");
		mainPage.getSignOff().click();
	}
	
	@AfterClass
	public void afterExecution() {
		driver.quitBrowser();
		System.out.println("Browser Closed Successfully..");
	}
}