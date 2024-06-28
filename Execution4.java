package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Execution4 {

	public WebDriver driver ;
	//cross-browser execution-----executing test script in more thn one browser
	@Parameters("browser")
	@Test	
	public void MyntraTest(String browser)
	{
		if (browser.equals("Chrome")) {
			driver =new ChromeDriver() ;
			
		} else {
		    driver =new EdgeDriver() ;
		}
		
		driver.get("https://www.myntra.com/");
	}
}
