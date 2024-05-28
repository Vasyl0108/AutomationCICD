package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	
	{
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	// WebElement userEmails = driver.findElement(By.id("userEmail"));
	// PageFactory
	
	@FindBy (id="userEmail") //or scc="login", or xpath="login"
	WebElement userEmail;
	
	@FindBy (id="userPassword")
	WebElement passwordEle;
	
	@FindBy (id="login")
	WebElement submit;
	
	@FindBy (css="[class*='flyInOut']")
	WebElement errorMessage;

	
	public ProductCatalogue loginApplication (String email, String password)
	
	{
		
		userEmail.sendKeys("chukvasyl@gmail.com");
		passwordEle.sendKeys("4513213Chuk$Vasyl");
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
        public  void loginApplicationWrong (String email, String password)
	
	{
		
		userEmail.sendKeys("chukvasyl@gmail.com");
		passwordEle.sendKeys("4513213");
		submit.click();
	
	}
	
        public  ProductCatalogue loginApplicationNew (String email, String password)
    	
    	{
        	
    		userEmail.sendKeys("anshika@gmail.com");
    		passwordEle.sendKeys("Iamking@000");
    		submit.click();
    		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
    		return productCatalogue;
    	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	
	public void goTo ()
	
	{
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
