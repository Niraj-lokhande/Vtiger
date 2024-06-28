package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	public WebDriver driver;
	
	@FindBy (xpath="//img[@alt='Create Organization...']")
	private WebElement createorg;

	public WebElement getCreateorg() {
		return createorg;
	}
	
	//create constructor
	public OrganisationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this) ;
	}
	//create method
	public OrgInformationPage organisations()
	{
		createorg.click();
		return new OrgInformationPage(driver) ;
	}

}
