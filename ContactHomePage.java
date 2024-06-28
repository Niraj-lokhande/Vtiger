package pom2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.WebDriverUtil;

public class ContactHomePage extends WebDriverUtil {

	//identify organisation
		@FindBy (xpath="(//a[text()='Organizations'])[1]")
		private WebElement org;
		
		//identify contacts
		@FindBy (xpath="//a[text()='Contacts']")
		private WebElement contact;
		
		
		//identify img
		@FindBy (xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement img;
		
		
		//click sign out
		@FindBy (xpath="//a[text()='Sign Out']")
		private WebElement signout;


		public WebElement getOrg() {
			return org;
		}


		public WebElement getContact() {
			return contact;
		}


		public WebElement getImg() {
			return img;
		}


		public WebElement getSignout() {
			return signout;
		}
		
		//create constructor 
		public ContactHomePage(WebDriver driver) {
			PageFactory.initElements(driver, this) ;
			////this will hold the refr of ContactHomePage object
		}
		
		//create method
		public void contactHome()
		{
			//create on contact
			contact.click();
			
			
			
		}
		public void contactHome(WebDriver driver)
		{
			//mouse hover on image
			mouseHover(driver, img);
			
			//clickon signout
			signout.click();
		}
}
