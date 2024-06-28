package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Execution2 {

	//suffix should be test in methodname
	
	//parallel execution mode = methods
		@Test
		
		public void MyntraTest()  
		{
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.myntra.com/");
		}
		
	   @Test
		
		public void ZomatoTest()  
		{
		   WebDriver driver = new ChromeDriver();
			driver.get("https://www.zomato.com/");
		}
	   
	   @Test
		
		public void AjioTest()  
		{
		   WebDriver driver = new ChromeDriver();
			driver.get("https://www.ajio.com/");
		}
	   
	   @Test
		
		public void SwiggyTest()  
		{
		   WebDriver driver = new ChromeDriver();
			driver.get("https://www.swiggy.com/");
		}
}
