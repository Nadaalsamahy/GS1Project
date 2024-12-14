package gs1Scenario;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.ElementActions;


public class MainPage {
	private WebDriver driver;
	ElementActions elementAction;

	public MainPage(WebDriver driver) {
		this.driver = driver; 
	}
	private By bankLink =By.xpath("//a[h2[text()='Banking']]\r\n");
	
	
	public void  clickOnbankLink() {
		elementAction = new ElementActions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(bankLink));
		elementAction.clickButton(bankLink);
	}
	




	}


