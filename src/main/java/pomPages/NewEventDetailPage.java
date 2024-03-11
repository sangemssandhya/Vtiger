package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewEventDetailPage {
//declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	
	//Initialization
	
		public NewEventDetailPage(WebDriver driver)
		{
	PageFactory.initElements(driver,this);
		}

		//Utilization
	public String getPageHeader() {
	return pageHeader.getText();
	}
}
