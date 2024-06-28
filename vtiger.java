package basicTestNG;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


//login
//click 3 line xpath with index 1 .click() 
//mouse  hover => marketing (text()) ----before mouse hover apply threads
//actions obj
//in marketing click contact text() with index 1
//click add contacts 
//scroll down with the help of javascriptexecutor & apply thread before
//inspect uplaod=> div[class='fileUploadBtn btn btn-primary']
//use autoit to upload the file

public class vtiger {
	
	@Test
	public void vtigerTest() throws InterruptedException, IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) ;
		driver.get("https://demo.vtiger.com/vtigercrm");
		
		Thread.sleep(3000) ;
		driver.findElement(By.xpath("//button[text()='Sign in']")).click() ;
		driver.findElement(By.xpath("(//span[@class='app-icon fa fa-bars'])[1]")).click() ;
		Thread.sleep(3000) ;
		WebElement marketing = driver.findElement(By.xpath("//span[text()=' MARKETING']")) ;
		Actions a =new Actions(driver) ;
		a.moveToElement(marketing).perform() ;
		
		driver.findElement(By.xpath("(//span[text()=' Contacts'])[1]")).click() ;
		driver.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")).click() ;
		//driver.findElement(By.cssSelector("div[class='fileUploadBtn btn btn-primary']")).click() ;
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)") ;
		
		Thread.sleep(6000) ;
		
		driver.findElement(By.cssSelector("div[class='fileUploadBtn btn btn-primary']")).click() ;
		
		Thread.sleep(6000) ;
		//inspect upload with .click()
		Runtime.getRuntime().exec("C:\\Users\\DELL\\Desktop\\AutoIT\\newFile.exe") ;
		
		
	}

}
