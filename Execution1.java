package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Execution1 {

	//suffix should be test in methodname
	
	@Test(groups="Shopping")
	
	public void MyntraTest()  
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
	}
	
   @Test(groups="Food")
	
	public void ZomatoTest()  
	{
	   WebDriver driver = new ChromeDriver();
		driver.get("https://www.zomato.com/");
	}
   
   @Test(groups="Shopping")
	
	public void AjioTest()  
	{
	   WebDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
	}
   
   @Test(groups="Food")
	
	public void SwiggyTest()  
	{
	   WebDriver driver = new ChromeDriver();
		driver.get("https://www.swiggy.com/");
	}
}
