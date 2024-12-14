package gs1ScenarioTest;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import gs1Scenario.AccountPage;
import gs1Scenario.AddCustomerPage;
import gs1Scenario.BankMangerLoginPage;
import gs1Scenario.CustomersPage;
import gs1Scenario.DeleteAccountPage;
import gs1Scenario.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static ChromeOptions option;
	protected MainPage mainPage;
	protected BankMangerLoginPage bankMangerLoginPage;
	protected AddCustomerPage addcustomerPage;
	protected CustomersPage customerPage;
	protected AccountPage accountPage;
	protected DeleteAccountPage deleteAccountPage;
	@BeforeSuite
	public void startDriver()  {
		ChromeOptions co =new ChromeOptions();	
		WebDriver driver = WebDriverManager.chromedriver().capabilities(co).create();
		driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
		driver.manage().window().maximize();
		mainPage = new MainPage(driver);
		bankMangerLoginPage = new BankMangerLoginPage(driver);
		addcustomerPage = new AddCustomerPage(driver);
		customerPage = new CustomersPage(driver);
		accountPage = new AccountPage(driver);
		deleteAccountPage = new DeleteAccountPage(driver);
	}
	
	       /* @AfterSuite
	public void stopDriver() {
	        	driver.quit();

	}*/


	}

