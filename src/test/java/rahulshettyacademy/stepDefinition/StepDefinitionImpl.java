package rahulshettyacademy.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.CartPage;
import rahulshettyacademy.CheckoutPage;
import rahulshettyacademy.ConfirmationPage;
import rahulshettyacademy.LandingPage;
import rahulshettyacademy.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;

public class StepDefinitionImpl extends BaseTest {

	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;

	@Given("I landed on Ecommerce Page")

	public void I_landed_on_Ecommerce_Page() throws IOException

	{
		landingPage = launchApplication();
	}

	@Given("Logged in with username {string} and password {string}")

	public void Logged_in_with_username_and_password(String username, String password) {

		productCatalogue = landingPage.loginApplication(username, password);
	}

	@When("^I add product (.+) to Cart$")

	public void I_add_product_to_Cart(String productName) {

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}

	@And("^checkout (.+) and submit the order$")

	public void checkout_submit_order(String productName) throws InterruptedException {

		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}

	@Then("{string} message is displayed on ConfirmationPage")

	public void message_displayed_ConfirmationPage(String string) throws InterruptedException {

		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	}

	@Then ("^\"([^\"]*)\" message is displayed$")
	{
	public void something_message_is_displayed(String strArg1)
	
	Assert.assertEquals(strArg1, landingPage.getErrorMessage());
	driver.close();
	}
	
}