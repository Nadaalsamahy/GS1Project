package gs1Scenario;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.ElementActions;

public class BankMangerLoginPage {
	private WebDriver driver;
	ElementActions elementAction;

	public BankMangerLoginPage(WebDriver driver) {
		this.driver = driver; 
	}
	private By bankMangerLoginBtn =By.xpath("//button[@ng-click='manager()']");

	
	public void clickOnbankMangerLoginBtn() {
		
		elementAction = new ElementActions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(bankMangerLoginBtn));
		elementAction.clickButton(bankMangerLoginBtn);

		
	}
	
	



}
