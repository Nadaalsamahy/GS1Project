package gs1Scenario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVWriter;

import util.ElementActions;

public class AddCustomerPage {
	private WebDriver driver;
	ElementActions elementAction;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver; 
	}
	
	private By addCustomerBtn =By.xpath("//button[@ng-click='addCust()']");
	private By firstNameField =By.xpath("//input[@ng-model='fName']");
	private By lastNameField =By.xpath("//input[@placeholder='Last Name']");
	private By postalCodeField =By.xpath("//input[@ng-model='postCd']");
	private By submitBtn =By.xpath("//button[text()='Add Customer']");
	
	public void  clickOnAddCustomrBtn() {
		
		elementAction = new ElementActions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(addCustomerBtn));
		elementAction.clickButton(addCustomerBtn);
		
		
	}
	public void typeFirstName(String firstName) {
		elementAction = new ElementActions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
		elementAction.typeValue(firstNameField, firstName);
		}
	
	public String getFirstNameTxt() {

		elementAction = new ElementActions(driver);
        System.out.println("FirstName Field" + firstNameField);
        
		return elementAction.getElementText(firstNameField);
	}
	public void typeLastName(String lastName) {
		elementAction = new ElementActions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
		elementAction.typeValue(lastNameField, lastName);
        System.out.println("FirstName Field" + firstNameField);
	}

	public void typePostalCode(String postalCode) {
		elementAction = new ElementActions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
		elementAction.typeValue(postalCodeField, postalCode);
	}
	

	public void  clickOnsubmitBtn() {
		
		elementAction = new ElementActions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		elementAction.clickButton(submitBtn);	
		
	}
	public int clickOnokOnAlert() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
        System.out.println("The extracted Customer ID is: "+ alertText);
        String number = extractNumberFromText(alertText);
        System.out.println("Extracted Number: " + number);
		alert.accept();
		String Id = extractNumberFromText(number);
		return Integer.parseInt(Id);
        
	}
        public  String extractNumberFromText(String text) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                return matcher.group();
            }
            return "No number found"; 
            
       
}
	
	    
	}
