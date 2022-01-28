package TESTINT00360FEIBOutbound;
//package Tests;
//
//import java.io.IOException;
//
//import org.testng.ITestContext;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//
//import Funtions.SearchPositionIdDTrace;
//import Funtions.SearchWMAID;
//import Funtions.SearchWPNID;
//import Funtions.SearchPositionIdDTrace;
//import Utility.ExcelLib;
//import Utility.GenericLib;
//import jxl.read.biff.BiffException;
//
//public class SearchWPNIDTest {
//	/**
//	 * Created by Susovan
//	 */
//	GenericLib gl = new GenericLib(this.getClass().getSimpleName());
//
//	@DataProvider
//	public Object[][] data(ITestContext context) throws BiffException, IOException {
//		ExcelLib xl = new ExcelLib("WD-R Data", "TC001");
//		return xl.getTestdata();
//	}
//	//	@BeforeMethod
////	@BeforeClass
////	public void loginRun() throws Exception {
////
////		gl.killProcess("VIPUIManager.exe");
////		SearchPositionIdDTrace searchPositionId = new SearchPositionIdDTrace();
////		searchPositionId.loginDTrace();
////		
////	}
//	@BeforeMethod
//	public void loginRun() throws Exception {
//		
//	Funtions.SearchWPNID dtrace = new Funtions.SearchWPNID();
//	dtrace.beforemethod();
//	dtrace.loginDTrace1();
//
//	}
//	
//	
//	
//	@Test(dataProvider = "data")
//		public void SearchWPNId(String Requisition_Number, String WPN ,String Position_ID, String Requisition_Status, 
//				String Number_External_Candidates, String Number_Internal_Candidates, String Number_Candidates_Offered, 
//				String Number_Candidates_Matched,String Number_Candidates_Shortlisted, 
//				String Number_Candidates_Interviewed, String Number_Candidates_Declined_Rejected, String Number_Candidates_Accepted)throws Exception {
//
////		SearchPositionIdDTrace searchPositionId = new SearchPositionIdDTrace();
////		SearchPLMIdTest SearchPLMId = new SearchPLMIdTest();
//		SearchWPNID WPNOBJ2 = new SearchWPNID();
//		
//		
//		//searchPositionId.loginDTrace();
//		WPNOBJ2.searchWMPNIDTest(Requisition_Number,  WPN, Position_ID , Requisition_Status,  
//				Number_External_Candidates,  Number_Internal_Candidates,  Number_Candidates_Offered,  Number_Candidates_Matched , 
//				Number_Candidates_Shortlisted,  Number_Candidates_Interviewed,
//				Number_Candidates_Declined_Rejected, Number_Candidates_Accepted);
//	}
//
////	@AfterMethod
////	public void afterend() {
////		
////		SearchPositionIdDTrace searchPositionIdDTrace = new SearchPositionIdDTrace();
////		searchPositionIdDTrace.beforemethod();
////		searchPositionIdDTrace.afterMethod();
////	}
////
////	@AfterClass
////	public void afterFinis() {
////		SearchPositionIdDTrace searchPositionIdDTrace = new SearchPositionIdDTrace();
////		searchPositionIdDTrace.afterfinish();
////	}
//	@AfterMethod
//	public void afterend() {
//	Funtions.SearchWPNID PPM = new Funtions.SearchWPNID();
//	PPM.beforemethod();
//	PPM.afterMethod();
//	}
//
//	
//}
