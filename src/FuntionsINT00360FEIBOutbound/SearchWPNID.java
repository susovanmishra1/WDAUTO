package FuntionsINT00360FEIBOutbound;
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
//public class SearchWPNID extends BaseClass {
//	GenericLib gl = new GenericLib(this.getClass().getSimpleName());
//	public void loginDTrace1() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
//		extent = ExtentManger.GetExtent();
//		//Launch Browser
//		Properties config = new Properties();
//		String path = System.getProperty("user.dir");// return project folder path
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
//		Thread.sleep(10000);
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
//	public void searchWMPNIDTest(String Requisition_Number, String WPN ,String Position_ID, 
//			String Requisition_Status, String Number_External_Candidates, 
//			String Number_Internal_Candidates, String Number_Candidates_Offered, 
//			String Number_Candidates_Matched,String Number_Candidates_Shortlisted, 
//			String Number_Candidates_Interviewed, String Number_Candidates_Declined_Rejected, 
//			String Number_Candidates_Accepted) throws Exception {
//
//		JSWaiter.setDriver(driver);
//		JSWaiter jsw = new JSWaiter();
//		jsw.waitAllRequest();
//		Thread.sleep(10000);
//
////		gl.inputText(Elements.textboxSearchPosition, "position_id",position_id);
////		Dgl.inputText(Elements.textboxPLMBOX, "PLM_ID",PLM_ID);
//		gl.inputText(Elements.SearchWPNBOX, "WPN", WPN);
//		
//		Thread.sleep(10000);
//		gl.clickElementByJs(Elements.EnterWPNBox, "WPNID");
////		gl.clickElementByJs(Elements.textboxSearchPlMBox, "PLMID");
//		
////		gl.clickElementByJs(Elements.textboxSearchPlMBox, "PLMID");
//		System.out.println("wait");
//		Thread.sleep(10000);
//		
//		gl.clickElement(Elements.WPN_PpmExpand, "Expand");
//		System.out.println("Expand now");
//		
//		gl.verifystrings(Elements.RequisitionLink, Requisition_Number,"Requisition_Number");
//		gl.verifystrings(Elements.WpnLink, WPN,"WPN");
//		gl.verifystrings(Elements.StatusLink,Requisition_Status, "Requisition_Status");
//		gl.verifystrings(Elements.ExternalCandidatestLink,Number_External_Candidates,"Number_External_Candidates");
//		Thread.sleep(10000);
//		gl.verifystrings(Elements.InternallCandidatestLink,Number_Internal_Candidates,"Number_Internal_Candidates");
//		gl.verifystrings(Elements.CandidatesOfferedLink,Number_Candidates_Offered,"Number_Candidates_Offered");
//		gl.verifystrings(Elements.CandidatesMatchedLink,Number_Candidates_Matched,"Number_Candidates_Matched");
//		gl.verifystrings(Elements.CandidatesShortlistLink,Number_Candidates_Shortlisted,"Number_Candidates_Shortlisted");
//		
//		gl.verifystrings(Elements.CandidatesInterviewLink,Number_Candidates_Interviewed,"Number_Candidates_Interviewed");
//		Thread.sleep(10000);
//		gl.verifystrings(Elements.CandidatesRejectedLink,Number_Candidates_Declined_Rejected,"Number_Candidates_Declined_Rejected");
//		
//		gl.verifystrings(Elements.CandidatesAcceptedLink,Number_Candidates_Accepted,"Number_Candidates_Accepted");
//	}
//
//	@BeforeMethod
//	public void beforemethod() {
//		extent = ExtentManger.GetExtent();
//	}
//
//	@AfterMethod
//	public void afterMethod() {
//		driver.quit();
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
