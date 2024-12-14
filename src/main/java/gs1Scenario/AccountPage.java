package gs1Scenario;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.ElementActions;

public class AccountPage {
	
	private WebDriver driver;
	ElementActions elementAction;

	public AccountPage(WebDriver driver) {
		this.driver = driver; 
	}
	
	private By openAccountBtn =By.xpath("//button[@ng-click='openAccount()']");
	private By openCustomerDropdown =By.xpath("//select[@id='userSelect']");
	private By openCurruncyDropdown =By.xpath("//select[@id='currency']");
	private By processBtn = By.xpath("//button[text()='Process']");

	public void  clickOnCustomrBtn() {
		
		elementAction = new ElementActions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(openAccountBtn));
		elementAction.clickButton(openAccountBtn);
		
	}
   public void  clickOnopenCustomerDropdown() {
		
		elementAction = new ElementActions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(openCustomerDropdown));
		elementAction.clickButton(openCustomerDropdown);
	}

   public void clickonLastElementinDropDownList() {
	   WebElement dropdown = driver.findElement(By.xpath("//select[@id='userSelect']"));
       Select select = new Select(dropdown);
       List<WebElement> options = select.getOptions();
       select.selectByIndex(options.size() - 1);
   }
   public void  clickOpenCurruncyDropdown() {
		
		elementAction = new ElementActions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(openCurruncyDropdown));
		elementAction.clickButton(openCurruncyDropdown);
		
	}
   public void selectRandomDropdownOption() {
       WebElement dropdown = driver.findElement(By.xpath("//select[@id='currency']"));
       Select select = new Select(dropdown);
       List<WebElement> options = select.getOptions();
       Random random = new Random();
       int randomIndex = random.nextInt(options.size() - 1) + 1; 
       select.selectByIndex(randomIndex);
       System.out.println("Selected option: " + options.get(randomIndex).getText());
   }
	public void  clickOnProcessBtn() {
		
		elementAction = new ElementActions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(processBtn));
		elementAction.clickButton(processBtn);
		
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
            // Regular expression to find numbers (integer or floating-point)
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(text);

            // If a number is found, return it
            if (matcher.find()) {
                return matcher.group();
            }
            return "No number found"; 
}}
