package testscripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateLeadTest extends BaseClass {
	@Test
	public void createLeadTest() throws InterruptedException
	{
		home.clickLeads();
		soft.assertEquals(lead.getPageHeader(),"Leads");
		lead.clickPlusButton();
		soft.assertEquals(createlead.getPageHeader(),"Creating New Lead");
		Map<String,String>map=excel.readFromExcel("Create lead","LeadsTestData");
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		String companyName=map.get("Company");
		createlead.setLastName(lastName);
		createlead.setCompany(companyName);
		createlead.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newLead.getPageHeader().contains(lastName));
		 newLead.clickLeadsLink();
		 if(lead.getNewLeadName().equals(lastName))
			{
				System.out.println("test pass");
				excel.updateTestStatus("Create lead", "pass", IConstantPath.EXCEL_PATH,"LeadsTestData");
			}
			else
			{
				System.out.println("test fail");
				excel.updateTestStatus("Create lead", "fail", IConstantPath.EXCEL_PATH,"LeadsTestData");
			}
		 soft.assertEquals(lead.getNewLeadName(),lastName);
			soft.assertAll();
		
	}


}
