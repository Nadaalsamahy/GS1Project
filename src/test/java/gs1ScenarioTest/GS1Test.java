package gs1ScenarioTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.Delayed;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import gs1Scenario.AddCustomerPage;


public class GS1Test extends BaseTest {
	private Faker dataFaker = new Faker();
	private String firstName = dataFaker.toString();
	private String LastName = dataFaker.toString();
	private String postalCode = dataFaker.toString();	
	private  int customerID;
	private  int accountNumber;

	@Test()
	public void Scenario1() throws IOException {
		//mainPage.clickOnbankLink();
		bankMangerLoginPage.clickOnbankMangerLoginBtn();
		addcustomerPage.clickOnAddCustomrBtn();
		addcustomerPage.typeFirstName(firstName);
		addcustomerPage.getFirstNameTxt();
		addcustomerPage.typeLastName(LastName);
		addcustomerPage.typePostalCode(postalCode);
		addcustomerPage.clickOnsubmitBtn();
		customerID = addcustomerPage.clickOnokOnAlert();
		customerPage.clickOnCustomrBtn();
		customerPage.getRowCount();
		assertEquals(customerPage.getRowCount(), customerID);
		customerPage.getRowCount();
		customerPage.getTextFromLastRow();
		
		//assertion 

		assertTrue(customerPage.getDataFromLastRow().contains(firstName));
		assertTrue(customerPage.getDataFromLastRow().contains(LastName));
		assertTrue(customerPage.getDataFromLastRow().contains(postalCode));
		
		
	}
	@Test()
	public void Scenario2() throws IOException {
	accountPage.clickOnCustomrBtn();
	accountPage.clickOnopenCustomerDropdown();
	accountPage.clickonLastElementinDropDownList();
	accountPage.clickOpenCurruncyDropdown();
	accountPage.selectRandomDropdownOption();
	accountPage.clickOnProcessBtn();
	accountNumber = accountPage.clickOnokOnAlert();
	customerPage.clickOnCustomrBtn();
	assertTrue(customerPage.getDataFromLastRow().contains(String.valueOf(accountNumber)));
	
}
	@Test()
	public void Scenario3() {
		deleteAccountPage.delete();
		
	}

}

	

	
		
	

	

