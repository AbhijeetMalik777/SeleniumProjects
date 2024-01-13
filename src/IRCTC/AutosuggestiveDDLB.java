package IRCTC;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestiveDDLB {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("(//input[@class='ng-tns-c57-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted'])[1]")).sendKeys("amrits");
		Thread.sleep(2000);
		List <WebElement>  options = driver.findElements(By.cssSelector("li[role='option']"));
		for(WebElement option: options )
		{
			if(option.getText().equalsIgnoreCase("BATALA JN - BAT (AMRITSAR)"))
			{
				option.click();
				break;
				
			}
		}
	}
	

}
