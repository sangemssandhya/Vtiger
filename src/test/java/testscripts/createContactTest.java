package testscripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class createContactTest extends BaseClass {
	@Test
	public void CreateContactTest() throws InterruptedException
	{
		home.clickContacts();//naviagte to home page of contact
		soft.assertEquals(contact.getPageHeader(),"Contacts");
		contact.clickPlusButton();
		soft.assertEquals(createContact.getPageHeader(),"Creating New Contact");
		Map<String,String>map=excel.readFromExcel("Create Contact","ContactsTestData");
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createContact.setLastName(lastName);
		createContact.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newContact.getPageHeader().contains (lastName));

		 newContact.clickContactsLink();
		 if(contact.getNewContactName().equals(lastName))
			{
				System.out.println("test pass");
				excel.updateTestStatus("Create Contact", "pass", IConstantPath.EXCEL_PATH,"ContactsTestData");
			}
			else
			{
				System.out.println("test fail");
				excel.updateTestStatus("Create Contact", "fail", IConstantPath.EXCEL_PATH,"ContactsTestData");
			}
		 soft.assertEquals(contact.getNewContactName(),lastName);
			soft.assertAll();
		
	}

}
