package gs1Scenario;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.ElementActions;

public class DeleteAccountPage {
	private WebDriver driver;
	ElementActions elementAction;

	public DeleteAccountPage(WebDriver driver) {
		this.driver = driver; 
	}
		   
	public void  delete() {
			
		   List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));
		WebElement deleteButton = rows.get(rows.size()-1).findElement(By.xpath("//button[@ng-click='deleteCust(cust)']"));
		deleteButton.click();
		
	       System.out.println("Deleted successfully");
	       try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
			
		}
	   
	


}
