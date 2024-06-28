package commonUtils;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	//public static WebDriver sdriver;
     //WebDriver driver= new ChromeDriver();
	public WebDriver driver ;
	
	//declaration is done for taking screenshot
	public static WebDriver sdriver ;
     
     
	PropertyFileUtil pf =new PropertyFileUtil() ;
	WebDriverUtil wu = new WebDriverUtil() ;
	
//	public BaseClass()
//	{
//		driver = new ChromeDriver();
//	}


	@BeforeSuite
		
	public void BeforeSuite1()
	{
		System.out.println("Connect todata base");
	}
	
	@BeforeClass
	
	public void BeforeClass1() throws IOException
	{
		//before class is used to launch application
	  // driver = new ChromeDriver();
			
		String browser = pf.getDataFromPropertyFile("Browser") ;
		String url = pf.getDataFromPropertyFile("Url") ;
		
		if(browser.equals("Chrome")) {
			 driver= new ChromeDriver() ;
		}
		else if(browser.equals("Edge")) {
			 driver = new EdgeDriver() ;
			
		}
		else  {
			 driver = new FirefoxDriver() ;
			
		}
		wu.maximize(driver);
		wu.impliwait(driver);
		
		//initialization is only for takescreenshot----sdriver is used in listenerimplementation
		sdriver=driver ;
		driver.get(url);
		
		
		
	}
	@BeforeMethod
	
	public void BeforeMethod1() throws IOException
	{
		//@BeforeMethod is used to login to the application
		
		String userName = pf.getDataFromPropertyFile("Username") ;
		String userPass = pf.getDataFromPropertyFile("Password") ;
		
		//enter username & password in text field
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(userPass);
		driver.findElement(By.id("submitButton")).click();
	}
	
	@AfterMethod
	
	public void AfterMethod1() throws InterruptedException
	{
		//@AfterMethod is used to signout from the application
		
		Thread.sleep(3000);
		//mouse hover on img for sign out
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wu.mouseHover(driver, img) ;
				
		//click on sign out
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click() ;
				  
	}
	
	@AfterClass
	
	public void AfterClass1()
	{
		//after class is used to close the browser
		driver.quit() ;
	}
	
	@AfterSuite
	public void AfterSuite1()
	{
		System.out.println("Disconnect with database");
	}
	
	
}

