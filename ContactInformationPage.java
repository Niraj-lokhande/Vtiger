package pom2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.WebDriverUtil;

public class ContactInformationPage {
	WebDriverUtil wu = new WebDriverUtil() ;
	
	@FindBy (xpath="//input[@name='firstname']")
	private WebElement firstName;
	
	@FindBy (xpath="//input[@name='lastname']")
	private WebElement lastName;
	
	@FindBy (xpath="//input[@value='T']")
	private WebElement grpBtn;
	
	@FindBy (name="assigned_group_id")
	private WebElement dropDown;
	
	@FindBy (xpath="(//input[@name='button'])[1]")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getGrpBtn() {
		return grpBtn;
	}

	public WebElement getDropDown() {
		return dropDown;
	}
	
	//create constructor
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this) ;
	}
	
	//create method
		public void contactInformation(String firstNameData,String secondNameData,String targetedElement)
		{
			//enter first name
			firstName.sendKeys(firstNameData);
			
			//enter first name
			lastName.sendKeys(secondNameData);
			
			//click on group button
			grpBtn.click();
			
			//to select dropdown => support group in dropdown
			wu.handleDropdown(dropDown, targetedElement);
			
			//click on save button
			saveBtn.click();
			
		}

}
