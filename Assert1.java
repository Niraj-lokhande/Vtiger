package basicTestNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//dont give class name as Assert
public class Assert1 {
	

	@Test 
	public void Myntra()
	{
		
		WebDriver driver =new ChromeDriver() ;
		driver.get("https://www.myntra.com/");
		String actulurl = driver.getCurrentUrl() ;
		//System.out.println(url);
		String expUrl ="https://www.myntra.com/pune" ;
		
		//Assert.assertEquals(actulurl,expUrl) ;
		//assertEquals(actulurl, expUrl) ;
		/*
		 * String title = driver.getTitle() ; //System.out.println(title);
		 * 
		 * if(url.equals("https://www.myntra.com/pune")) {
		 * System.out.println("URL is matching"); } else {
		 * System.out.println("URL is not matching"); }
		 */
		String actualTitle =driver.getTitle() ;
		String expTitle ="Onlines Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra" ;
		//assertEquals(actualTitle, expTitle) ; //if class name is Assert
		Assert.assertEquals(actualTitle, expTitle) ;
		
		System.out.println("HElloo");
		
	}

}
