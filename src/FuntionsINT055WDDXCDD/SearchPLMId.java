package FuntionsINT055WDDXCDD;
//package Funtions;
//
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.Toolkit;
//import java.awt.datatransfer.Clipboard;
//import java.awt.datatransfer.DataFlavor;
//import java.awt.datatransfer.UnsupportedFlavorException;
//import java.awt.event.KeyEvent;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;
//
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//import Utility.BaseClass;
//import Utility.Elements;
//import Utility.ExtentManger;
//import Utility.GenericLib;
//import Utility.JSWaiter;
//
//public class SearchPLMId extends BaseClass {
//	GenericLib gl = new GenericLib(this.getClass().getSimpleName());
//
//
//	public void loginDTrace() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
//		extent = ExtentManger.GetExtent();
//		//Launch Browser
//		Properties config = new Properties();
//		String path = System.getProperty("user.dir");   // return project folder path
//
//		String filepath = path + "\\src\\Config\\Config.properties";
//		//		System.out.println("Searching config in :" + configpath);
//
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream(filepath);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			config.load(fis);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			driver=gl.launchApplication(config.getProperty("browser"), config.getProperty("URLDTrace"));
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//		driver.findElement(By.xpath(xpathExpression))
//		gl.inputText(Elements.LoginUN, "LoginUN",config.getProperty("UserName") );
//
//		gl.clickElement(Elements.SubmitNext, "SubmitNext");
//
//		gl.inputText(Elements.Username, "LoginUN",config.getProperty("UserName") );
//
//		gl.inputText(Elements.Password, "Password",config.getProperty("Password") );
//		Thread.sleep(1000);
//
//
//
//
//		try {
//			gl.clickElement(Elements.SignIn, "SignInButton");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		gl.clickElement(Elements.SendPush, "SendPush");
//		Thread.sleep(10000);
//
//
//		//		Robot r = new Robot();
//
//		/*
//		 * r.keyPress(KeyEvent.VK_WINDOWS); r.keyPress(KeyEvent.VK_D);
//		 * r.keyRelease(KeyEvent.VK_D); r.keyRelease(KeyEvent.VK_WINDOWS);
//		 */
//
//		//Thread.sleep(8000);
//		//		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "vipstart.bat");
//		//		String path = System.getProperty("user.dir"); 
//		//		File dir = new File("C:\\Users\\smishra270\\PPM_mvn_2412\\Dtrace_Automation");
//		//		String filepath = path + "\\src\\Config\\Config.properties";
//		/*		
//		System.out.println("Searching config in :" + filepath);
//		File dir = new File(path);
//		pb.directory(dir);
//		Process p = pb.start();
//		Thread.sleep(2000);;
//		r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_C);
//		r.keyRelease(KeyEvent.VK_C);
//		r.keyRelease(KeyEvent.VK_CONTROL);
//		Thread.sleep(1000);
//		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//77,85,89 to 100,comments*/
//		//		String code=clipboard.getData(DataFlavor.stringFlavor).toString();
//
//
//		//		System.out.println("VIPCode-----------------> "+code);
//		//		gl.inputText(Elements.VIPCode, "VIPCODE", code);
//		try {
//			driver.manage().window().maximize();
//			System.out.println("waiting now for maximize the screen");
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		Thread.sleep(10000);
//		//		gl.clickElement(Elements.VIPCodeSubmit,"VIPCodeSubmit");
//
//		JSWaiter.setDriver(driver);
//		JSWaiter jsw = new JSWaiter();
//		jsw.waitAllRequest();
//
//	}
//
//
//	public void searchPLMIDTest(String  position_id,String  position_status,String  POSITIONSUBSTATUS,
//			String  FORCAST_STATUS,String  Position_Reason,String  BILL_TYPE,String  CATEGORY,
//			String  ServiceOffering,String  ServiceType,String  country_name,String  Job_Level,
//			String  STARTDATE,String  FINISHDATE,String  PLM_ID,String  PRIMARYPROJECTMANAGER,
//			String  demandcontact,String  primary_suboffering,String  primary_role,String  primary_skill_required,
//			String  Secondary_Skill_Required,String  ResourcePool_Name,String  Resource_Executive,String  STAFFINGPROFILEID,
//			String  ProjectID,String  Project_Name,String  Demand_Status,String  ProjectStartdate,String  ProjectEnddate,
//			String  BusinessArea,String  Industry,String  Account_ID,String  AccountName,
//			String  OWNINGREGION,String  OWNINGCOUNTRY,String  FTE,String  Allocation_FTE) throws Exception {
//
//		JSWaiter.setDriver(driver);
//		JSWaiter jsw = new JSWaiter();
//		jsw.waitAllRequest();
//
////		gl.inputText(Elements.textboxSearchPosition, "position_id",position_id);
//		gl.inputText(Elements.textboxPLMBOX, "PLM_ID",PLM_ID);
//		Thread.sleep(10000);
//		
//		gl.clickElementByJs(Elements.textboxSearchPlMBox, "PLMID");
//		
//		Thread.sleep(10000);
//		
//		gl.clickElement(Elements.PpmExpand1, "Expand");
//		System.out.println("Expand now");
//
//		gl.verifystrings(Elements.PLMIDvalue, PLM_ID,"PLM_ID");
//		
//		gl.verifystrings(Elements.textPositionlink, position_id,"Position_ID");
//		Thread.sleep(1000);
//		gl.verifystrings(Elements.PositionStatusvalue, position_status,"position_status");
//		System.out.println("verified positionstatusvalue");
//
//		gl.verifystrings(Elements.PositionSubstatusvalue, POSITIONSUBSTATUS,"POSITIONSUBSTATUS");
//		Thread.sleep(1000);
//		gl.verifystrings(Elements.ForecastStatusvalue, FORCAST_STATUS,"FORCAST_STATUS");
//		Thread.sleep(1000);
//		gl.verifystrings(Elements.PositionReasonvalue, Position_Reason,"Position_Reason");
//		
//		gl.verifystrings(Elements.BillingTypevalue, BILL_TYPE,"BILL_TYPE");
//		
//		gl.verifystrings(Elements.Categoryvalue, CATEGORY,"CATEGORY");
//		
//		gl.verifystrings(Elements.ServiceOfferingvalue, ServiceOffering,"ServiceOffering");
//		
//		gl.verifystrings(Elements.ServiceTypevalue, ServiceType,"ServiceType");
//		
//		gl.verifystrings(Elements.LocationCountryvalue, country_name,"country_name");
//		
//		gl.verifystrings(Elements.JobLevelvalue, Job_Level,"Job_Level");
//		
//		gl.verifystrings(Elements.StartDatevalue, STARTDATE,"STARTDATE");
//		Thread.sleep(1000);
//		gl.verifystrings(Elements.FinishDatevalue, FINISHDATE,"FINISHDATE");
//		
//		gl.verifystrings(Elements.PLMIDvalue, PLM_ID,"PLM_ID");
//		
//		gl.verifystrings(Elements.PrimaryManagervalue, PRIMARYPROJECTMANAGER,"PRIMARYPROJECTMANAGER");
//		
//		gl.verifystrings(Elements.DemandContactvalue, demandcontact,"DemandContactvalue");
//		
//		
//		gl.verifystrings(Elements.PrimarySkillvalue, primary_skill_required,"PrimarySkillvalue");
//		
//		gl.verifystrings(Elements.SecondarySkillvalue, Secondary_Skill_Required,"SecondarySkillvalue");
//		
//		
////		###############/*Resource Pool: INS:Life and Wealth BPS:Compliance Resource*/###################
//		
//		gl.clickElementByJs(Elements.ResourcePoolExpand, "Expand");
//		
//			
//		
//		gl.verifyList(Elements.ResourcingExecutivevalues, Resource_Executive,"Resource_Executive");
//		gl.verifyList(Elements.ResourcePoolvalue, ResourcePool_Name,"ResourcePoolvalue");
//		
//		
//		
//		
//		
//		
////		###############/*Position Project: INS:Life and Wealth BPS:*/###################
//
//	
//
//		gl.clickElementByJs(Elements.PpmExpand1, "Expand");
//		
//		Thread.sleep(10000);
//
//		gl.clickElementByJs(Elements.PositionProjectExpand, "Expand");
//		//		
//
//
//		gl.verifystrings(Elements.ProjectLinkValue, ProjectID,"ProjectID");
//
//		gl.verifystrings(Elements.DemandstatusValue, Demand_Status,"Demand_Status");
//
//		gl.verifystrings(Elements.BusinessAreaValue, BusinessArea,"BusinessArea");
//
//		gl.verifystrings(Elements.IndustryValue, Industry,"Industry");
//		gl.verifystrings(Elements.AccountNameValue, AccountName,"AccountName");
//
//		gl.verifystrings(Elements.OwningregionValue, OWNINGREGION,"OWNINGREGION");
//
//		gl.verifystrings(Elements.OwningCountryValue, OWNINGCOUNTRY,"OWNINGCOUNTRY");
//		
//	}
//
//
//	public void searchPostionData(String XID,String status,String request_Type,String PositionFor,
//			String BusinessArea,String RequesterName,String HiringManagerName,String OwningRegion,
//			String OwningCountry,String PositionID,String PositionName,String ProjectID,String ProjName,
//			String WPN,String SLII,String req_request_source_ia,String External_Hire,String AgencyContractor_New,
//			String Internal_Requisition,String LTE,String AgencyContractor_Extension) throws Exception { 
//
//		JSWaiter.setDriver(driver);
//		JSWaiter jsw = new JSWaiter();
//		jsw.waitAllRequest();
//
////		gl.inputText(Elements.textboxSearchPosition, "PositionID",PositionID);
//		gl.clickElementByJs(Elements.buttonSearch, "Position");
//		gl.waitForElementToAppear(Elements.WMA_PpmExpand, 10);
//		gl.clickElementByJs(Elements.WMA_PpmExpand, "Expand");
//		gl.verifystrings(Elements.WMAPositionValue, PositionID,"PositionID");
//		
//
//
//	}
//
//
//
//	@BeforeMethod
//	public void beforemethod() {
//		extent = ExtentManger.GetExtent();
//	}
//
//	@AfterMethod
//	public void afterMethod() {
//   	driver.quit();
//		extent.flush();
//	}
//
//
//	public void afterfinish() {
//		driver.quit();
//	}
//}
//
//
//
//
//
//
//
//
//
//
