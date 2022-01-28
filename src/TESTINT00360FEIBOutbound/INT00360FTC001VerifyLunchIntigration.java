package TESTINT00360FEIBOutbound;

import static org.apache.commons.lang.StringUtils.isBlank;

import Utility.ExcelLib;
import Utility.GenericLib;
import jxl.read.biff.BiffException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class INT00360FTC001VerifyLunchIntigration {
	/**
	 * Created by
	 */

	GenericLib gl = new GenericLib(this.getClass().getSimpleName());

   @DataProvider
	public Object[][] data(ITestContext context) throws BiffException, IOException {
		ExcelLib xl = new ExcelLib("TC1lunchIntigrationSucessfully","TC001");
		return xl.getTestdata();
	}

	@BeforeMethod
	public void loginRun() throws Exception {
	   FuntionsINT00360FEIBOutbound.INT00360FTC001VerifyLunchIntigration wday1 = new FuntionsINT00360FEIBOutbound.INT00360FTC001VerifyLunchIntigration();
       wday1.beforemethod();
        wday1.Login();
        
	
	}

	@Test(dataProvider = "data")
	public void searchPositionFromExcel(String Intigration_ID) throws Exception
	{
		FuntionsINT00360FEIBOutbound.INT00360FTC001VerifyLunchIntigration wday = new FuntionsINT00360FEIBOutbound.INT00360FTC001VerifyLunchIntigration();
		wday.beforemethod();
		wday.VerifyLunchIntigration(Intigration_ID);
	}

	@AfterMethod
	public void afterend() {
		FuntionsINT055WDDXCDD.FunctionVerifyWorkdaylaunch wday = new FuntionsINT055WDDXCDD.FunctionVerifyWorkdaylaunch();
		wday.beforemethod();
		wday.afterMethod();
	}

}
