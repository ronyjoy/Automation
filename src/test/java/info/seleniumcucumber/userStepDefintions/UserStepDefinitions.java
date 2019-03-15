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

public class UserStepDefinitions implements BaseTest {

	protected WebDriver browser = DriverUtil.getDefaultDriver();
	
	private String name ="";

	@Given("^that user goto the login page \"([^\"]*)\"$")
	public void thatUserGotoTheLoginPage(String loginPage) throws Throwable {
		browser.get(loginPage);
		browser.findElement(By.className("btn-primary")).click();
		Thread.sleep(2000);
		
	}

	@When("^I try to enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void iTryToEnterUsernameAndPassword(String email, String password) throws Throwable {
		browser.findElement(By.name("email")).sendKeys(email);
		browser.findElement(By.name("password")).sendKeys(password);
		browser.findElement(By.className("auth0-label-submit")).click();
		Thread.sleep(3000);
	}

	@Then("^I should be able to login$")
	public void iShouldBeAbleToLogin() throws Throwable {
		Assert.assertNotNull(browser.findElement(By.className("navbar-brand")));
		browser.close();
	}

	@Then("^I should not be able to login$")
	public void iShouldNotBeAbleToLogin() throws Throwable {
		Assert.assertEquals("WRONG EMAIL OR PASSWORD.", browser.findElement(By.className("animated")).getText());
		browser.close();
	}   

	@Then("^I should see a login failure message \"([^\"]*)\"$")
	public void iShouldSeeALoginFailureMessage(String message) throws Throwable {
		Assert.assertEquals(message, browser.findElement(By.className("animated")).getText());
		browser.close();
		
	}

	@Then("^I should see a validation failure message \"([^\"]*)\"$")
	public void iShouldSeeAValidationFailureMessage(String message) throws Throwable {
		Assert.assertEquals(message, browser.findElement(By.className("auth0-lock-error-invalid-hint")).getText());
		browser.close();
	}

	@Given("^that I logged into the application$")
	public void thatILoggedIntoTheApplication() throws Throwable {
	
	}

	@And("^go to the list customer$")
	public void goToTheListCustomer() throws Throwable {
	}

	@Then("^I should see customer list with pagination$")
	public void iShouldSeeCustomerListWithPagination() throws Throwable {
	}


	@When("^I try to login with facebook username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void iTryToLoginWithFacebookUsernameAndPassword(String email, String pass) throws Throwable {
		browser.findElement(By.className("auth0-lock-social-button-text")).click();
		Thread.sleep(3000);
		browser.findElement(By.id("email")).sendKeys(email);
		browser.findElement(By.id("pass")).sendKeys(pass);
		browser.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}

	@When("^I try to click on \"([^\"]*)\"$")
	public void iTryToClickOn(String arg1) throws Throwable {
		
	}

	@When("^I try to login with google username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void iTryToLoginWithGoogleUsernameAndPassword(String email, String pass) throws Throwable {
		browser.findElement(By.xpath("(//div[@class='auth0-lock-social-button-text'])[2]")).click();
		Thread.sleep(3000);
		browser.findElement(By.name("identifier")).sendKeys(email);
		browser.findElement(By.className("RveJvd")).click();
		Thread.sleep(3000);
		browser.findElement(By.name("password")).sendKeys(pass);
		browser.findElement(By.className("RveJvd")).click();
	
	}

	@Given("^that when I goto add customer page$")
	public void thatWhenIGotoAddCustomerPage() throws Throwable {
		browser.get("http://bpmsportal.com/dashboard/addcustomer");
		Thread.sleep(2000);
	}

	@When("^I entered all the required information and submit$")
	public void iEnteredAllTheRequiredInformationAndSubmit() throws Throwable {
		name = "Sonu Rony"+System.currentTimeMillis();
		browser.findElement(By.id("add-customer_name")).sendKeys(name);
		browser.findElement(By.id("add-customer_address")).sendKeys("3748 Turetella Dr");
		browser.findElement(By.id("add-customer_phone")).sendKeys("5129037017");
		browser.findElement(By.id("add-customer_fax")).sendKeys("5129037017");
		browser.findElement(By.id("add-customer_contactPerson")).sendKeys("Neave");
		browser.findElement(By.id("add-customer_email")).sendKeys("sonurony@gmail.com");
		browser.findElement(By.className("ant-btn-primary")).click();
		Thread.sleep(3000);
		
	}


	@Then("^Customer is saved$")
	public void customerIsSaved() throws Throwable {

		browser.get("http://bpmsportal.com/dashboard/customers");
		browser.findElement(By.className("container-fluid")).getText().contains(name);
		browser.close();
		
		
	}


	@When("^I skipped contact person mandatory fields to enter$")
	public void iSkippedContactPersonMandatoryFieldsToEnter() throws Throwable {
		browser.findElement(By.id("add-customer_name")).sendKeys("Sonu Rony");
		browser.findElement(By.id("add-customer_address")).sendKeys("3748 Turetella Dr");
		browser.findElement(By.id("add-customer_phone")).sendKeys("5129037017");
		browser.findElement(By.id("add-customer_fax")).sendKeys("5129037017");
		browser.findElement(By.id("add-customer_email")).sendKeys("sonurony@gmail.com");
		browser.findElement(By.className("ant-btn-primary")).click();
		Thread.sleep(3000);
	}

	@Then("^I should get \"([^\"]*)\" required error when I submit the details$")
	public void iShouldGetRequiredErrorWhenISubmitTheDetails(String arg1) throws Throwable {
		Assert.assertEquals(arg1, browser.findElement(By.className("ant-form-explain")).getText());
		browser.close();
		
	}




	




	

	

}

