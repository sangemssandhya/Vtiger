package testscripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class createAndDeleteLeadTest extends BaseClass {
	@Test
	public void createLeadTest() throws InterruptedException
	{
		home.clickLeads();
		lead.clickPlusButton();
		Map<String,String>map=excel.readFromExcel("Delete lead","LeadsTestData");
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		String companyName=map.get("Company");
		createlead.setLastName(lastName);
		createlead.setCompany(companyName);
		createlead.clickSave();
		Thread.sleep(3000);
		 newLead.clickLeadsLink();
		 lead.deleteLead(web, lastName);
		 web.handleAlert("OK");
		 if(lead.getNewLeadName().equals(lastName))
			{
				System.out.println("test pass");
				excel.updateTestStatus("Delete lead", "pass", IConstantPath.EXCEL_PATH,"LeadsTestData");
			}
			else
			{
				System.out.println("test fail");
				excel.updateTestStatus("Delete lead", "fail", IConstantPath.EXCEL_PATH,"LeadsTestData");
			}
	}


}
