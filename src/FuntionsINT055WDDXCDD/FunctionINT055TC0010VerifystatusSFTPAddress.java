package FuntionsINT055WDDXCDD;
import Utility.*;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.util.Properties;

public class FunctionINT055TC0010VerifystatusSFTPAddress extends BaseClass {
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
	    gl.inputText(Elements.workday_username, "workday_username",config.getProperty("UserName"));
		gl.inputText(Elements.workday_Password, "workday_Password",config.getProperty("Password"));
		gl.clickElement(Elements.workday_SignInButton, "workday_SignInButton");
		Thread.sleep(10000);
			
	}

	public void verifyConfigSFTPAddress(String Intigration_ID,String Status,String Status1) throws Exception {

		JSWaiter.setDriver(driver);
		JSWaiter jsw = new JSWaiter();
		jsw.waitAllRequest();
//		Thread.sleep(2000);
		
//		gl.ClickButton(Elements.workday_searchicon, "workday_searchicon");
		gl.clickElement(Elements.workday_searchicon, "global SearchInput");
//		Thread.sleep(2000);
//		gl.inputTextandTab(Elements.workday_globalSearchbox, "workday_globalSearchbox", "Position_ID");
		gl.inputTextandEnter(Elements.workday_globalSearchbox, "Intigration_ID",Intigration_ID);
//		Thread.sleep(2000);
		gl.clickElement(Elements.workday_searchicon, "workday_searchicon");
//		gl.ClickButton(Elements.workday_searchicon, "workday_searchicon");
//		Thread.sleep(15000);
		////start?????//
		gl.clickElement(Elements.INT055RequisitionDetails, "INT055RequisitionDetails");
//		driver.findElement(By.xpath("//button[@data-automation-id='pex-related-actions']")).click();
//    	driver.findElement(By.xpath("//div[@data-automation-id='pex-search-result-header']")).click();
//		gl.clickElement(Elements.IService, "INT055-RequisitionDetails-WD-DXCDD");
//        Thread.sleep(5000);
		gl.ScrollPage();
		
		
		gl.clickElement(Elements.BusinessProcess, "BusinessProcess");
//		gl.clickElement(Elements.INT055RequisitionDetails, "INT055-RequisitionDetails-WD-DXCDD");
		gl.clickElement(Elements.BusinessProceeDefination, "BusinessProcess");
		
		gl.clickElement(Elements.Magnifiericon, "BusinessProcess");
//        gl.getFieldText(Elements.SFTP,"SFTP");
		gl.ScrollPage();
        gl.getFieldText(Elements.SFTPITGAddress,"SFTPAddress for ITG -sftp://sftp-wd-itg.itcs.houston.dxc.technology:8183");
       
		Thread.sleep(5000);
		gl.ScrollPage();
		gl.verifystrings(Elements.SFTPITGAddress, Status,"SFTPAddress for ITG ");
		gl.ScrollPage();
		
		gl.getFieldText(Elements.SFTPPROAddress,"SFTPAddress for PRO -sftp://sftp-wd-pro.itcs.houston.dxc.technology:8183");
		gl.ScrollPage();
		gl.verifystrings(Elements.SFTPPROAddress, Status1,"SFTPAddress for PRO ");
		gl.ScrollPage();
//		gl.takeScreenShot(Intigration_ID);
		gl.ScreenShotReport1(Intigration_ID);
//		gl.takeScreenShot(Status1);

	
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
