package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContactDetailPage {
	
	//DECLARATION
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement contactLink;
	
	//Initialization
	
	public NewContactDetailPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization
	
	public String getPageHeader()
	 {
		 return pageHeader.getText();
	 }
	public void clickContactsLink()
	{
		contactLink.click();
	}
}
