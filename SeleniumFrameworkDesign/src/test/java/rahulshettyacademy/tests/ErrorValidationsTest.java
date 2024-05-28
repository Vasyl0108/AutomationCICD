package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.CartPage;
import rahulshettyacademy.CheckoutPage;
import rahulshettyacademy.ConfirmationPage;
import rahulshettyacademy.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;

public class ErrorValidationsTest extends BaseTest {

		
	@Test (groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidations() throws IOException {
	
		String productName = "ZARA COAT 3";
		landingPage.loginApplicationWrong("chukvasyl@gmail.com", "4513213Chuck$Star");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	
	@Test
	public void ProductErrorValidation() throws IOException {
	
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("chukvasyl@gmail.com", "4513213Chuck$Star");
		List<WebElement>products = productCatalogue.getProductList();
	    productCatalogue.addProductToCart(productName);
	    CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
	    
		
		
	}
	
}


