package vtigerCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuperChild extends Super1 {

	public static  WebDriver driver;
	public static void main(String[] args) {
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click() ;

	}

}
