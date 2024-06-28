package basicTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertFalsee {
	
	@Test
	public void Myntr() {
		WebDriver driver =new ChromeDriver() ;
		driver.get("https://www.myntra.com/");
		WebElement searchtf = driver.findElement(By.className("desktop-searchBar")) ;
		
		//Assert.assertFalse(searchtf.isDisplayed());//--true condition---fail
		Assert.assertFalse(searchtf.isSelected()); //---false conditn--pass
		Assert.assertFalse(searchtf.isEnabled());
		System.out.println("Helloww");
		
		
	}

}
