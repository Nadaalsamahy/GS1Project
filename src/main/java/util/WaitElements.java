package util;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class WaitElements {
	private WebDriver driver;

	public WaitElements(WebDriver driver) {
		this.driver = driver;

}
	private int timeOutInSeconds=30;
	private int pollingEveryNanos=1;
	
	public void waitVisibilityOfElement(By byLocator) {
		FluentWait<WebDriver> waitElement = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofNanos(pollingEveryNanos))
				.ignoring(NoSuchElementException.class);
		waitElement.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));
	}

	public void waitVisibilityOfElement(WebElement byElement) {
		FluentWait<WebDriver> waitElement = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofNanos(pollingEveryNanos))
				.ignoring(NoSuchElementException.class);
		waitElement.until(ExpectedConditions.visibilityOf(byElement));
	}
	public void waitInvisibilityOfElement(By byLocator) {
		FluentWait<WebDriver> waitElement = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofNanos(pollingEveryNanos))
				.ignoring(NoSuchElementException.class);
		waitElement.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
	}
	
	public void waitClickabilityOfElement(WebElement element) {
		FluentWait<WebDriver> waitElement = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofNanos(pollingEveryNanos))
				.ignoring(NoSuchElementException.class);
		waitElement.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitClickabilityOfElement(By element) {
		FluentWait<WebDriver> waitElement = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofNanos(pollingEveryNanos))
				.ignoring(NoSuchElementException.class);
		waitElement.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitPresenceOfAllElementsLocatedBy(By element) {
		FluentWait<WebDriver> waitElement = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofNanos(pollingEveryNanos))
				.ignoring(NoSuchElementException.class);
		waitElement.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
	}
}
	
