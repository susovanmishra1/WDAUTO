package TESTINT00360FEIBOutbound;
//package Tests;
//
//import java.io.IOException;
//
//import org.testng.ITestContext;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//
//
//import Funtions.SearchPositionIdDTrace;
//import Funtions.SearchPositionIdDTrace;
//import Utility.ExcelLib;
//import Utility.GenericLib;
//import jxl.read.biff.BiffException;
//
//public class SearchPLMIdTest {
//	/**
//	 * Created by Susovan
//	 */
//
//	GenericLib gl = new GenericLib(this.getClass().getSimpleName());
//
//	@DataProvider
//	public Object[][] data(ITestContext context) throws BiffException, IOException {
//		//System.out.println("Test Case Name: "+context.getCurrentXmlTest().getParameter("TestcaseName"));
//		//ExcelLib xl = new ExcelLib("TestData", context.getCurrentXmlTest().getParameter("TestcaseName"));
//		ExcelLib xl = new ExcelLib("Position Search", "TC001");
//		//ExcelLib xL=new ExcelLib("TestData","TC001");
//		return xl.getTestdata();
//	}
//
//	//	@BeforeMethod
//	/*@BeforeClass
//	public void loginRun() throws Exception {
//
//		gl.killProcess("VIPUIManager.exe");
//		SearchPositionIdDTrace searchPositionId = new SearchPositionIdDTrace();
//		searchPositionId.loginDTrace();
//	}*/
//	@BeforeMethod
//	public void loginRun() throws Exception {
//		
//	Funtions.SearchPLMId dtrace = new Funtions.SearchPLMId();
//	dtrace.beforemethod();
//	dtrace.loginDTrace();
//
//	}
//
//	@Test(dataProvider = "data")
//		public void SearchPLMId(String  position_id,String  position_status,String  POSITIONSUBSTATUS,
//				String  FORCAST_STATUS,String  Position_Reason,String  BILL_TYPE,String  CATEGORY,
//				String  ServiceOffering,String  ServiceType,String  country_name,String  Job_Level,
//				String  STARTDATE,String  FINISHDATE,String  PLM_ID,String  PRIMARYPROJECTMANAGER,
//				String  demandcontact,String  primary_suboffering,String  primary_role,String  primary_skill_required,
//				String  Secondary_Skill_Required,String  ResourcePool_Name,String  Resource_Executive,String  STAFFINGPROFILEID,
//				String  ProjectID,String  Project_Name,String  Demand_Status,String  ProjectStartdate,String  ProjectEnddate,
//				String  BusinessArea,String  Industry,String  Account_ID,
//				String  AccountName,String  OWNINGREGION,String  OWNINGCOUNTRY,String  FTE,String  Allocation_FTE)throws Exception {
//
////		SearchPositionIdDTrace searchPositionId = new SearchPositionIdDTrace();
////		SearchPLMIdTest SearchPLMId = new SearchPLMIdTest();
//		Funtions.SearchPLMId PLMOBJ1 = new Funtions.SearchPLMId();
//		
//		//searchPositionId.loginDTrace();
//		PLMOBJ1.searchPLMIDTest(position_id,position_status,POSITIONSUBSTATUS,FORCAST_STATUS,
//				Position_Reason,BILL_TYPE,CATEGORY,ServiceOffering,ServiceType,country_name,Job_Level,STARTDATE,FINISHDATE,
//				PLM_ID,PRIMARYPROJECTMANAGER,demandcontact,primary_suboffering,primary_role,primary_skill_required,
//				Secondary_Skill_Required,ResourcePool_Name,Resource_Executive,STAFFINGPROFILEID,ProjectID,Project_Name,
//				Demand_Status,ProjectStartdate,
//				ProjectEnddate,BusinessArea,Industry,Account_ID,AccountName,OWNINGREGION,OWNINGCOUNTRY,FTE,Allocation_FTE);
//	}
//
//	@AfterMethod
//	public void afterend() {
//	Funtions.SearchPLMId PPM = new Funtions.SearchPLMId();
//	PPM.beforemethod();
//	PPM.afterMethod();
//	}
//
//}
