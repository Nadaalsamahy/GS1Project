package gs1Scenario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;

import net.sf.saxon.instruct.ForEach;
import util.ElementActions;

public class CustomersPage {
	private WebDriver driver;
	ElementActions elementAction;

	public CustomersPage(WebDriver driver) {
		this.driver = driver; 
	}
	
	private By customers =By.xpath("//button[@ng-click='showCust()']");
	private By row =By.xpath("//tr[@class='ng-scope']/td[3]");

	
	public void  clickOnCustomrBtn() {
		
		elementAction = new ElementActions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(customers));
		elementAction.clickButton(customers);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    public int getRowCount() {
        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));
        System.out.println("Rows = " + rows.size());
        return rows.size();

    }
    public String getTextFromLastRow() {
        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));
        if (rows.size() > 0) {
            WebElement lastRow = rows.get(rows.size() - 1);
            String rowText = lastRow.getText();
            System.out.println("Last row text: " + rowText);  // For debugging
            return rowText;
        } else {
            System.out.println("No rows found in the table.");
            return null;
        }
        }
    public List<String> getDataFromLastRow() {
        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));
        if (rows.size() > 0) {
            WebElement lastRow = rows.get(rows.size() - 1);
            List<WebElement> cells = lastRow.findElements(By.xpath(".//td"));
            List<String> rowData = new ArrayList<>();
            for (WebElement cell : cells) {
                rowData.add(cell.getText());
            }
            System.out.println("Data from last row: " + rowData);
            return rowData;
        } else {
            System.out.println("No rows found in the table.");
            return null;
        }
    }
    
	


   
    }

   

	


