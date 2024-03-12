package testscripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateAndDuplicateLeadTest extends BaseClass
{
	@Test
	public void createAndDuplicateLeadTest() throws InterruptedException
	{
		home.clickLeads();//navigate to leads home page
		soft.assertEquals(lead.getPageHeader(),"Leads");
		lead.clickPlusButton();//navigate to leads plus button
		soft.assertEquals(createlead.getPageHeader(),"Creating New Lead");
		Map<String,String>map=excel.readFromExcel("Create and Duplicate Lead","LeadsTestData");
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createlead.setLastName(lastName);
		createlead.setCompany(map.get("Company"));
		createlead.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newLead.getPageHeader().contains(lastName));
		 newLead.clickDuplicate();
		 soft.assertTrue(duplicatelead.getPageHeader().contains(lastName));
		 String newlastName=map.get("New Last Name")+jutil.generateRandomNum(100);
		 duplicatelead.setLastName(newlastName);
		 duplicatelead.clickSave();
		 Thread.sleep(3000);
		 soft.assertTrue(newLead.getPageHeader().contains(newlastName));
		 newLead.clickLeadsLink();

		 
		 if(lead.getNewLeadName().equals(lastName))
			{
				System.out.println("test pass");
				excel.updateTestStatus("Create and Duplicate Lead", "pass", IConstantPath.EXCEL_PATH,"LeadsTestData");
			}
			else
			{
				System.out.println("test fail");
				excel.updateTestStatus("Create and Duplicate Lead", "fail", IConstantPath.EXCEL_PATH,"LeadsTestData");
			}
		 soft.assertEquals(lead.getNewLeadName(),newlastName);
			soft.assertAll();
		
	}


}
