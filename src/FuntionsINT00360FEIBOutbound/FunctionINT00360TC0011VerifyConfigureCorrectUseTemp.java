package FuntionsINT00360FEIBOutbound;
import Utility.*;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.util.Properties;

public class FunctionINT00360TC0011VerifyConfigureCorrectUseTemp extends BaseClass {
	GenericLib gl = new GenericLib(this.getClass().getSimpleName());

	public void Login() throws Exception {
		extent = ExtentManger.GetExtent();
		Properties config = new Properties();
		String path = System.getProperty("user.dir"); // return project folder
		String configpath = path + "\\src\\Config\\Config.properties";
		System.out.println("Searching config in :" + configpath);

		FileInputStream fis = new FileInputStream(configpath);
		config.load(fis);
		gl.launchApplication(config.getProperty("browser"), config.getProperty("URLWorkday"));
		JSWaiter.setDriver(driver);
		JSWaiter jsw = new JSWaiter();
		jsw.waitAllRequest();
	
//		gl.inputTextandEnter(Elements.workday_username, "workday_username",config.getProperty("UserName"));
//		Thread.sleep(2000);
//		gl.inputText(Elements.workday_Password, "workday_Password",config.getProperty("Password"));
//		Thread.sleep(2000);
//		gl.ClickButton(Elements.workday_SignInButton, "workday_SignInButton");
//		gl.clickElement(Elements.workday_SignInButton, "workday_SignInButton");
		gl.inputText(Elements.workday_username, "workday_username",config.getProperty("UserName"));
		gl.inputText(Elements.workday_Password, "workday_Password",config.getProperty("Password"));
		gl.clickElement(Elements.workday_SignInButton, "workday_SignInButton");
//		Thread.sleep(10000);
			
	}

	public void VerifyCorrectUseTempFile(String Intigration_ID,String Status) throws Exception {

		JSWaiter.setDriver(driver);
		JSWaiter jsw = new JSWaiter();
		jsw.waitAllRequest();
//		Thread.sleep(2000);
		
//		gl.ClickButton(Elements.workday_searchicon, "workday_searchicon");
		gl.clickElement(Elements.workday_searchicon, "workday_search icon");
		Thread.sleep(2000);
//		gl.inputTextandTab(Elements.workday_globalSearchbox, "workday_globalSearchbox", Intigration_ID);
//		gl.inputText(Elements.workday_globalSearchbox,"Intigration_ID",Intigration_ID);
		gl.inputTextandEnter(Elements.workday_globalSearchbox, "Intigration_ID",Intigration_ID);
		Thread.sleep(2000);
		gl.clickElement(Elements.workday_searchicon, "workday_searchicon");

		gl.clickElement(Elements.IntigrationSystemLink, "INT00360F - National Identifier - EIB - Outbound");
//	
		gl.ScrollPage();
			

		gl.getFieldText(Elements.TEMPFile,"TEMPFile: YES ");
		gl.verifystrings(Elements.TEMPFile,Status, "TEMPFile");
//		gl.getFieldText(Elements.RPT2,"RPT - INT055 - Requisition Details - WD - DXCDD");

		
//	   
//       gl.clickElement(Elements.IService, "OK");
//		gl.clickElement(Elements.Integration_Events, "workday_IntigrationEvents");
//		System.out.println("Click Sucessfully");
//		System.out.println("Status");
//		Thread.sleep(5000);
//		gl.verifystrings(Elements.BusinessProceeDefination, Status,"RPT");
//		gl.ScrollPage();
//        gl.clickElementReport(Elements.OutputFiles, "OutputFiles");
//		gl.getobjecttextreport(Elements.OutputFilesLink, "OutputFilesLink");
		
//String 	atttachment= driver.findElement(By.xpath("//div[@data-automation-id='fileAttachment']")).getText();

//div[@data-automation-id='fileAttachment'])[1]/div/div
//		gl.clickElement(Elements.workday_IntigrationeventStatau, "Status");
//		gl.clickElement(Elements.workday_Ok1, "OK");
//		Thread.sleep(5000);
////		gl.clickElement(Elements.workday_Ok1, "OK");
//	//	gl.clickElement(Elements.workday_IEvents, "workday_IntigrationEvents");
//		System.out.println("Click Sucessfully");
////      gl.clickElement(Elements.Integration_EventsFailed, "FailedStatus");
////		gl.verifystrings(Elements.workday_Statusfailed, Status,"Status");
//		gl.ScrollPage();
//		gl.clickElementReport(Elements.OutputFiles, "CompletedwithError");
//		//*[text()='Completed With Errors']
//		Thread.sleep(15000);
	
	}

	@BeforeMethod
	public void beforemethod() {
		extent = ExtentManger.GetExtent();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		extent.flush();
	}
}
