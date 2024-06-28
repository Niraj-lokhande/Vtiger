package basicTestNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
		
	
	@Test
	public void Amazon()
	{
		System.out.println("Hie from Amazon");
		
	}
	
	@Test
	public void Facebook()
	{
		System.out.println("Hie from Facebook");
		
	}
	
	  @BeforeMethod public void BM() { System.out.println("Before Method"); }
	  
	  @AfterMethod public void AM() { System.out.println("After Method"); }
	 
	
	@BeforeClass
	public void BC()
	{
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void AC()
	{
		System.out.println("After class");
	}
	
	@BeforeTest
	
	public void BT()
	{
		System.out.println("Before Test");
	}
	
@AfterTest
	
	public void AT()
	{
		System.out.println("After Test");
	}

@BeforeSuite

public void BS()
{
	System.out.println("Before Suite");
}

@AfterSuite

public void As()
{
	System.out.println("After Suite");
}
	
	

}
