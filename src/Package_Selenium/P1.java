package Package_Selenium;


import org.openqa.selenium.chrome.ChromeDriver;

public class P1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		POM d1 = new POM(driver);
		d1.goTo();
	    d1.loginAppplication("tester@opstree.com", "TestEr@9656");
		//driver.quit();
		
	}

}
