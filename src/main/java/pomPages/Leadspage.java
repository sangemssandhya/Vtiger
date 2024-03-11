package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class Leadspage {
	
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement pageHeader;
	@FindBy(xpath="//img[@alt='Create Lead...']")
	private WebElement plusButton;
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[last()]/td[3]/a")
	private WebElement newLeadsLink;
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteButton;
	
	private String leadCheckBoxPath="//a[text()='%s']/ancestor::tr[@class='lvtColData']/descendant::input";

	
	//INItialization
	public  Leadspage(WebDriver driver) {
		 PageFactory.initElements(driver,this);
	 }

   //Utilization
	public String getPageHeader()
	 {
		 return pageHeader.getText();
	 }
	 public void clickPlusButton()
	 {
		plusButton.click();
		
	 }
	 public String getNewLeadName()
	 {
		return newLeadsLink.getText();
	 }
	 public void deleteLead(WebDriverUtility web,String leadName)
	 {
		 web.convertPathToWebElement(leadCheckBoxPath, leadName).click();
		 deleteButton.click();
	 }
}
