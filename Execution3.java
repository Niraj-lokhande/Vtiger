package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Execution3 {
	
	//parallel execution mode = classes
	
	@Test
	public void SkillraryTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoapp.skillrary.com/");
	}
	
	@Test
	public void vTigerTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.vtiger.com/vtigercrm/");
	}
}
