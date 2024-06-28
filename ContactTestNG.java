package vtigerCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonUtils.BaseClass;
import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class ContactTestNG extends BaseClass {

	PropertyFileUtil pf =new PropertyFileUtil() ;
	WebDriverUtil wu = new WebDriverUtil() ;
	ExcelUtil ex =new ExcelUtil() ;
	JavaUtil ju =new JavaUtil() ;
	
	@Test
	public void testContact() throws IOException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		wu.maximize(driver);
		wu.impliwait(driver);
       // String webUrl ="src\\\\test\\\\resources\\\\vtiger.properties" ;
		
        //login credential through property files
		String url = pf.getDataFromPropertyFile("Url") ;
		String userName = pf.getDataFromPropertyFile("Username") ;
		String userPass = pf.getDataFromPropertyFile("Password") ;
		
		driver.get(url);
		
		//enter username & password in text field
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(userPass);
		driver.findElement(By.id("submitButton")).click();
		
		//click on contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click() ;
		
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click() ;
		
		//to read data from excel file
		String firstName = ex.getDataFromExcel("Contacts", 0, 1) ;
		String lastName = ex.getDataFromExcel("Contacts", 1, 1) ;
		String assign = ex.getDataFromExcel("Contacts", 2, 1) ;
		String orgName = ex.getDataFromExcel("Contacts", 3, 1) ;
		
		//enter firstname & last name through excel file
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(firstName+ju.getRandomNumbers()) ;
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(lastName) ;
		
		
		//to fail test script
//		WebElement notify = driver.findElement(By.name("notify_owner")) ;
//	      
//		Assert.assertTrue(false) ;
		
		
		//to fail test script
		String actualUrl = driver.getCurrentUrl() ;
		String expUrl = "http://localhost:8888/pune/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing" ;
		Assert.assertEquals(actualUrl, expUrl) ;
		
		//click on group radio button
		driver.findElement(By.cssSelector("input[value='T']")).click() ;
		
		//click on dropdown
		WebElement dropDown = driver.findElement(By.name("assigned_group_id"));
		
		//select assignTo : Team Selling with webdriver utitlity method
		wu.handleDropdown(dropDown, assign) ;
		
		//select assignTo : Team Selling without webdriver utitlity method
		//Select s= new Select(dropDown) ;
		//s.selectByVisibleText("Team Selling");
		
		//click on organisation text field(+) button
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click() ;
		
		Thread.sleep(3000) ;
		
		//to take screenshot of create contact
		wu.screenShot(driver, "contact") ;
		
		//transfer driver control from parent window to child window without method
		
//		  Set<String> ids = driver.getWindowHandles() ;
//		  
//		  for (String str : ids) { String actUrl =
//		  driver.switchTo().window(str).getCurrentUrl(); //System.out.println(actUrl);
//		  
//		  String childUrl ="http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid="; 
//		 
//		  
//		  if(actUrl.contains(childUrl)) {
//		  
//		  }
//		  
//		  }
		 
		
		//enter organisation name
		//driver.findElement(By.id("search_txt")).sendKeys(orgName) ;
		
		
		//transfer driver control from parent window to child window with method
		
		wu.switchToWindow(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=") ;
		
		//enter organisation name in search text field
		driver.findElement(By.id("search_txt")).sendKeys(orgName) ;
		
		//click on search button
		driver.findElement(By.name("search")).click() ;
		
		//to click on organisation name
		driver.findElement(By.xpath("//a[text()='Qspider']")).click() ;
		
		//to transfer control from child window to parent window
		wu.switchToWindow(driver,"http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing" ) ;
		
//		//click on save button
//		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click() ;
//		
//		//mouse hover on img for sign out
//		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
//	    wu.mouseHover(driver, img) ;
//	    
//	  //click on sign out
//	  driver.findElement(By.xpath("//a[text()='Sign Out']")).click() ;
		
		
		
		
		
	}
}
