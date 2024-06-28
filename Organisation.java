package vtigerCRM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.BaseClass;
import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.ListenerImplimentation;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

@Listeners(ListenerImplimentation.class)

public class Organisation  {
	
	//create obj before @Test
	
	PropertyFileUtil pf =new PropertyFileUtil() ;
	WebDriverUtil wu = new WebDriverUtil() ;
	ExcelUtil ex =new ExcelUtil() ;
	JavaUtil ju =new JavaUtil() ;
	
	
	@Test

	public void organisationTest() throws IOException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		wu.maximize(driver);
		wu.impliwait(driver);
		
		//To read data from property file
		//String webUrl ="src\\\\test\\\\resources\\\\vtiger.properties" ;
		
		String url = pf.getDataFromPropertyFile("Url") ;
		String userName = pf.getDataFromPropertyFile("Username") ;
		String userPass = pf.getDataFromPropertyFile("Password") ;
		
		//to read data from excel file
		String orgName = ex.getDataFromExcel("Organisation", 0, 1) ;
		String group = ex.getDataFromExcel("Organisation", 1, 1) ;
		
		//launch appln
		driver.get(url);
		
		//login cred
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(userPass);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click() ;
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click() ;
		
		//enter organisation name 
		//random number for diff organisation name 
		driver.findElement(By.name("accountname")).sendKeys(orgName+ju.getRandomNumbers()) ;
		
		//in assignTo click on group
		driver.findElement(By.cssSelector("input[value='T']")).click() ;
		
		//in dropdown select dropdown select group
		WebElement dropDown = driver.findElement(By.name("assigned_group_id"));
		/*
		 * Select s =new Select(dropDown) ; s.selectByVisibleText(group) ;
		 */
		wu.handleDropdown(dropDown, group) ;
		
		//click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click() ;
		
		//driver.findElement(By.name("assigned_group_id")).click() ;
		
		//String path ="src\\test\\resources\\vtigerData.xlsx" ;
		//change company name using random numbers
		
		Thread.sleep(5000) ;
		//mouse hover on img for sign out
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wu.mouseHover(driver, img) ;
		
		//click on sign out
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click() ;
		  
	}
//contacts : copy paste till click on create contact
	//click on create contact + => enter first name => enter last name => assign to => group 
	//=> team selling => 
	
}
