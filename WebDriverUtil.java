package commonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {
	
	public WebDriver driver ;
	
	public void maximize(WebDriver driver)
	{
		//driver=new ChromeDriver() ;
		driver.manage().window().maximize();
		
	}
	
	public void impliwait(WebDriver driver)
	{
		//driver=new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
		
	}
	public void handleDropdown(WebElement element,String targetedEle)
	{
		Select s =new Select(element) ;
		s.selectByVisibleText(targetedEle);
	}
	
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions a =new Actions(driver) ;
		a.moveToElement(element) ;
		a.perform();
	}
	
	public void switchToWindow(WebDriver driver,String expectedUrl)
	{
		Set<String> ids = driver.getWindowHandles() ;
		for (String str : ids) {
			String actUrl = driver.switchTo().window(str).getCurrentUrl() ;
			
			if(actUrl.contains(expectedUrl))
			{
				break ;
			}
			
		}
	}
	
	public String screenShot(WebDriver driver, String scrnShotName) throws IOException
	{
		TakesScreenshot tk = (TakesScreenshot) driver ;
		File tempFile = tk.getScreenshotAs(OutputType.FILE) ;
		File destFile = new File("./ScreenShot/"+scrnShotName+".png") ;
		FileUtils.copyFile(tempFile, destFile);
		
		return destFile.getAbsolutePath() ;
	}

}
