package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert1 {

	@Test
	public void Myntr() {
		WebDriver driver =new ChromeDriver() ;
		driver.get("https://www.myntra.com/");
		String actUrl = driver.getCurrentUrl() ;
		String expUrl ="https://www.myntra.com/pune" ;
		//1.create obj of SoftAssert class
		SoftAssert as =new SoftAssert();
		
		//2.call assertEquals(boolean actual,boolean expected)
		//as.assertEquals(actUrl, expUrl) ; //pass for https://www.myntra.com/ & prints statement
		as.assertEquals(actUrl, expUrl) ;
		System.out.println("HEllow");
		as.assertAll() ; //mandotory
	}
}
