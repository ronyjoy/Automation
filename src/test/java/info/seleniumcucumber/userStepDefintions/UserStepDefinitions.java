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

}

