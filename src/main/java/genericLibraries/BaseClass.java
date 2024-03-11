package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pomPages.ContactsPage;
import pomPages.CreateNewContactPage;
import pomPages.CreateNewEventPage;
import pomPages.CreateNewLeadsPage;
import pomPages.CreateNewOrganizationPage;
import pomPages.DuplicatingLeadPage;
import pomPages.HomePage;
import pomPages.Leadspage;
import pomPages.Loginpage;
import pomPages.NewContactDetailPage;
import pomPages.NewEventDetailPage;
import pomPages.NewLeadsDetailsPage;
import pomPages.NewOrgDetailsPage;
import pomPages.OrganizationsPage;

public class BaseClass {
	//BeforeSuite
	//BeforeTest
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected JavaUtility jutil;
	protected WebDriver driver;
	protected SoftAssert soft;
	
	protected  Loginpage login;
	protected HomePage home;
	protected OrganizationsPage org;
	protected ContactsPage contact;
	protected Leadspage lead;
	protected CreateNewOrganizationPage createorg;
	protected CreateNewContactPage createContact;
	protected CreateNewLeadsPage createlead;
	protected CreateNewEventPage createEvent;
	protected DuplicatingLeadPage duplicatelead;
	protected NewOrgDetailsPage newOrg;
	protected NewContactDetailPage newContact;
	protected NewLeadsDetailsPage  newLead;
	protected NewEventDetailPage newEvent;

	@BeforeClass
	public void classSetup() {
	property=new PropertiesUtility();
	excel=new ExcelUtility();
	web=new WebDriverUtility();
	
	jutil=new JavaUtility();
	property.propertiesInit(IConstantPath.PROPERTIES_PATH);
	driver=web.launchBrowserAndMaximize(property.readFromProperties("browser"));
	web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
	
	}
	@BeforeMethod
	public void methodSetup()
	{
		login=new Loginpage(driver);
		home=new HomePage(driver);
		org=new OrganizationsPage(driver);
		contact=new ContactsPage(driver);
		lead=new Leadspage(driver);
		createorg=new CreateNewOrganizationPage(driver);
		createContact=new CreateNewContactPage(driver);
		createlead=new CreateNewLeadsPage(driver);
		createEvent=new CreateNewEventPage(driver);
		duplicatelead=new DuplicatingLeadPage(driver);
		newOrg=new NewOrgDetailsPage(driver);
		newContact=new NewContactDetailPage(driver);
		newLead=new NewLeadsDetailsPage(driver);
		newEvent=new NewEventDetailPage(driver);
		soft =new SoftAssert();
		
		excel.excelInit(IConstantPath.EXCEL_PATH,null);
		
		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(login.getPageHeader(),"vtiger");
		login.loginToVtiger(property.readFromProperties("username"),property.readFromProperties("password"));
		Assert.assertTrue(home.getPageHeader().contains("Home"));
	}
		@AfterMethod
		public void methodTeardown()
		{
			home.signOutOfApp(web);
			excel.closeExcel();
	}
	@AfterClass
	public void classTearDown()
	{
		web.quitAllWindows();
	}
	
	
	

}