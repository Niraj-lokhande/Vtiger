package basicTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Assert2 {

	@Test
	public void Myntra()
	{
		
		WebDriver driver =new ChromeDriver() ;
		driver.get("https://www.myntra.com/");
		WebElement searchtf = driver.findElement(By.className("desktop-searchBar")) ;
		
		//Assert.assertTrue(searchtf.isDisplayed()) ; //true passTestcase
		//Assert.assertTrue(searchtf.isSelected()) ;//false failure
		//Assert.assertTrue(searchtf.isEnabled()) ;  //true Pass
		System.out.println("HElloww");
		
	}
}
