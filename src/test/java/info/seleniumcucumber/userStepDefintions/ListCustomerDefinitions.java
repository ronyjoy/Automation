package info.seleniumcucumber.userStepDefintions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import env.DriverUtil;
import info.seleniumcucumber.methods.BaseTest;



public class ListCustomerDefinitions implements BaseTest {

	protected WebDriver browser = DriverUtil.getDefaultDriver();
	

	@Given("^that I go to http://bpmsportal\\.com/dashboard$")
	public void thatIGoToHttpBpmsportalComDashboard() throws Throwable {
		browser.get("http://bpmsportal.com/dashboard");
			
	}

	@When("^I go to list of  coustomer$")
	public void iGoToListOfCoustomer() throws Throwable {
		browser.findElement(By.className("nav")).findElement(By.linkText("Customer Mgt")).click();
		browser.findElement(By.linkText("List Customer")).click();
	}

	@Then("^I should be able to see list of coustomer$")
	public void iShouldBeAbleToSeeListOfCoustomer() throws Throwable {
		Assert.assertEquals("List Customer", browser.findElement(By.linkText("List Customer")).getText());
		//Assert.assertEquals("Contact Person", browser.findElement(By.linkText("Contact Person")).getText());
		//Assert.assertEquals("Email", browser.findElement(By.linkText("Email")).getText());
		//Assert.assertEquals("Phone", browser.findElement(By.linkText("Phone")).getText());
		browser.close();
		
	}

	@When("^I click on add coustomer$")
	public void iClickOnAddCoustomer() throws Throwable {
		browser.findElement(By.className("nav")).findElement(By.linkText("Customer Mgt")).click();
		browser.findElement(By.linkText("Add Customer")).click();
		Thread.sleep(3000);
		
		
	}

	@And("^enter all values$")
	public void enterAllValues() throws Throwable {
		browser.findElement(By.id("add-customer_name")).sendKeys("Dhanya Test1");
		browser.findElement(By.id("add-customer_contactPerson")).sendKeys("Dijoy");
		browser.findElement(By.id("add-customer_address")).sendKeys("1804 manada trail, Leander, TX");
		browser.findElement(By.id("add-customer_phone")).sendKeys("8707613009");
		browser.findElement(By.id("add-customer_fax")).sendKeys("8702738473");
		browser.findElement(By.id("add-customer_email")).sendKeys("Dhanya@gmail.com");
		//browser.findElement(By.id("add-customer_rank")).findElement(By.linkText("BAD")).click();
		//browser.findElement(By.id("add-customer_approved")).findElement(By.linkText("Yes")).click();
		browser.findElement(By.className("ant-btn-primary")).click();
	}

	@Then("^I should be able to see coustomer added to the list$")
	public void iShouldBeAbleToSeeCoustomerAddedToTheList() throws Throwable {
		browser.findElement(By.className("nav")).findElement(By.linkText("Customer Mgt")).click();
		browser.findElement(By.linkText("List Customer")).click();
		Thread.sleep(3000);
		List<WebElement> rows = browser.findElements(By.className("ag-row"));
		boolean found = false;
		for(int i =0; i<rows.size();i++){
			if(rows.get(i).getText().contains("Dhanya Test1"));
			{
				found = true;
			}
			
		}
		Assert.assertTrue(found);
		browser.close();
	}
}
		
		
	

	

