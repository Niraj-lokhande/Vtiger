package vtigerCRM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import commonUtils.BaseClass;
import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class OrganisationTestNG extends BaseClass {

	PropertyFileUtil pf =new PropertyFileUtil() ;
	WebDriverUtil wu = new WebDriverUtil() ;
	ExcelUtil ex =new ExcelUtil() ;
	JavaUtil ju =new JavaUtil() ;
	
	@Test
	public void testOrganise() throws EncryptedDocumentException, IOException {
		
		//to read data from excel file
				String orgName = ex.getDataFromExcel("Organisation", 0, 1) ;
				String group = ex.getDataFromExcel("Organisation", 1, 1) ;
				
				

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
				
				driver.findElement(By.name("assigned_group_id")).click() ;
	}
	
}
