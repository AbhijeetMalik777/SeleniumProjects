package Package_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class POM extends POM2{

	
	WebDriver driver;
	
	public POM(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements( driver, this);
	}
	//@FindBy(how= How.XPATH, using = "Email")
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement userEmail1;
	@FindBy(xpath ="//input[@placeholder='Password']")
	WebElement Password1;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	public void loginAppplication(String Email, String Password)  
	{
		userEmail1.sendKeys(Email);
		Password1.sendKeys(Password);
		submit.click();
		
	} 
	
	public void goTo()
	{
		driver.get("https://app.buildpiper.io/login");
	}
	
	
	
	
}



