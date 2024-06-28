package basicTestNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AjioTest {
	
	@Test (priority = 0,  invocationCount = 2)
	public void Facebook()
	{
		System.out.println("Hie from Facebook");
		ChromeDriver driver =new ChromeDriver() ;
		driver.get("https://www.facebook.com/");
	}
	
	@Test(priority = 2)
	public void Amazon()
	{
		System.out.println("Hie from Amazon");
		ChromeDriver driver =new ChromeDriver() ;
		driver.get("https://www.amazon.in/");
	}
	@Test(priority = 1)
	public void Myntra()
	{
		System.out.println("Myntra");
		ChromeDriver driver =new ChromeDriver() ;
		driver.get("https://www.myntra.com/");
	}
	

}
