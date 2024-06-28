package vtigerCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class VtigerLeads {
	
	PropertyFileUtil pf =new PropertyFileUtil() ;
	WebDriverUtil wu = new WebDriverUtil() ;
	ExcelUtil ex =new ExcelUtil() ;
	JavaUtil ju =new JavaUtil() ;
	
	@Test
	public void leasTest() throws IOException 
	{
		WebDriver driver = new ChromeDriver();
		wu.maximize(driver);
		wu.impliwait(driver);
        //String webUrl ="src\\\\test\\\\resources\\\\vtiger.properties" ;
		
        //login credential through property files
		String url = pf.getDataFromPropertyFile("Url") ;
		String userName = pf.getDataFromPropertyFile("Username") ;
		String userPass = pf.getDataFromPropertyFile("Password") ;
		
		driver.get(url);
		
		//enter username & password in text field
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(userPass);
		driver.findElement(By.id("submitButton")).click();
		
		//click on leads
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click() ;
		
		//click on create leads
		driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click() ;
		
		//read data from excel file
		
		//to read data from excel file
		String firstName = ex.getDataFromExcel("Leads", 0, 1) ;
		String lastName = ex.getDataFromExcel("Leads", 1, 1) ;
		String assign = ex.getDataFromExcel("Leads", 2, 1) ;
		
		
		//enter firstname & last name through excel file
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(firstName) ;//+ju.getRandomNumbers()
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(lastName) ;
		
		//click on group radio button
		driver.findElement(By.cssSelector("input[value='T']")).click() ;
		
		//click on dropdown
		WebElement dropDown = driver.findElement(By.name("assigned_group_id"));
				
		//select assignTo : Team Selling with webdriver utitlity method
		wu.handleDropdown(dropDown, assign) ;
		
	}
}