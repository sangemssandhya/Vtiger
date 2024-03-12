package testscripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class createContactWithOrgTest extends BaseClass {
	@Test
	public void createContactWithOrgTest() throws InterruptedException
	
	{
		home.clickContacts(); //navigate to contacts home page
		soft.assertEquals(contact.getPageHeader(),"Contacts");
		contact.clickPlusButton();
		soft.assertEquals(createContact.getPageHeader(),"Creating New Contact");
		Map<String,String>map=excel.readFromExcel("Create Contact With Organization","OrganizationsTestData");
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createContact.setLastName(lastName);
		createContact.selectExitingOrg(web, map.get("Organization Name"));
		createContact.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newContact.getPageHeader().contains (lastName));

		 newContact.clickContactsLink();
		 if(contact.getNewContactName().equals(lastName))
			{
				System.out.println("test pass");
				excel.updateTestStatus("Create Contact With Organization", "pass", IConstantPath.EXCEL_PATH,"OrganizationsTestData");
			}
			else
			{
				System.out.println("test fail");
				excel.updateTestStatus("Create Contact With Organization", "fail", IConstantPath.EXCEL_PATH,"OrganizationsTestData");
			}
		 soft.assertEquals(contact.getNewContactName(),lastName);
			soft.assertAll();
		
	}

	

}
