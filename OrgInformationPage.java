package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.WebDriverUtil;

public class OrgInformationPage {
	public WebDriver driver ;
	WebDriverUtil wu = new WebDriverUtil() ;

	@FindBy (name="accountname")
	private WebElement orgInfo;
	
	@FindBy (xpath="(//input[@name='assigntype'])[2]")
	private WebElement grpBtn;
	
	@FindBy (name="assigned_group_id")
	private WebElement dropDown;
	
	@FindBy (xpath="(//input[@name='button'])[1]")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public WebElement getGrpBtn() {
		return grpBtn;
	}

	public WebElement getOrgInfo() {
		return orgInfo;
	}
	
	public OrgInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this) ;
	}
	
	//create method
	public HomePage orgInformation(String orgNameData,String targetedElement)
	{
		//enter organisation name
		orgInfo.sendKeys(orgNameData);
		
		//click on group button
		grpBtn.click();
		
		//to select dropdown => support group in dropdown
		wu.handleDropdown(dropDown, targetedElement);
		
		//click on save button
		saveBtn.click();
		
		return new HomePage(driver);
		
	}
}
