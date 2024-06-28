package pom2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	@FindBy (xpath="//img[@alt='Create Contact...']")
	private WebElement createcontact;

	public WebElement getCreatecontact() {
		return createcontact;
	}

	public ContactPage(WebDriver driver) {
		 PageFactory.initElements(driver, this) ;
	}
	public void contacts()
	{
		createcontact.click();
	}
	
	
}
