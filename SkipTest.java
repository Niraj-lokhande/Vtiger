package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//Default test
//Tests run: 3, Failures: 1, Skips: 2

//Default suite
//Total tests run: 3, Passes: 0, Failures: 1, Skips: 2

public class SkipTest {
	
@Test(dependsOnMethods = "Swiggy")
	
	public void Zomato(){
	WebDriver driver =new ChromeDriver() ;
	driver.get("https://www.zomato.com/");
		
	}
	
	@Test(dependsOnMethods = "Swiggy")
	
	public void Facebook(){
		WebDriver driver =new ChromeDriver() ;
		driver.get("https://www.facebook.com/");
		
	}
	
   @Test
	
	public void Swiggy(){
	   WebDriver driver =new ChromeDriver() ;
		driver.get("https://www.swiggy.com/");
		String actUrl = driver.getCurrentUrl() ;
		String expUrl ="https://www.swiggy.com/pune" ;
		
		Assert.assertEquals(actUrl , expUrl);
		
		
	}
	

}
