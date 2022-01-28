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
import java.util.function.Function;

public class INT00360FTCVerifyLoginAndSearch {
	/**
	 * Created by Susovan Mishra
	 */

	GenericLib gl = new GenericLib(this.getClass().getSimpleName());

   @DataProvider
	public Object[][] data(ITestContext context) throws BiffException, IOException {
		ExcelLib xl = new ExcelLib("TCverifyLoginAndSearch", "TC001");
		return xl.getTestdata();
	}

	@BeforeMethod
	public void loginRun() throws Exception {
//		FuntionsINT055WDDXCDD.FunctionVerifyWorkdaylaunch wday = new FuntionsINT055WDDXCDD.FunctionVerifyWorkdaylaunch();
		FuntionsINT00360FEIBOutbound.FunctionVerifyWorkdaylaunch wday1 = new FuntionsINT00360FEIBOutbound.FunctionVerifyWorkdaylaunch();
		wday1.beforemethod();
		wday1.Login();
		System.out.println("EIB START SUSOVAN ");
	}

	@Test(dataProvider = "data")
	public void searchPositionFromExcel(String Intigration_ID) throws Exception {
		FuntionsINT00360FEIBOutbound.FunctionVerifyWorkdaylaunch wday = new FuntionsINT00360FEIBOutbound.FunctionVerifyWorkdaylaunch();
		wday.beforemethod();
		wday.verifyLoginAndSearch(Intigration_ID);
	}

	@AfterMethod
	public void afterend() {
		FuntionsINT055WDDXCDD.FunctionVerifyWorkdaylaunch wday = new FuntionsINT055WDDXCDD.FunctionVerifyWorkdaylaunch();
		wday.beforemethod();
		wday.afterMethod();
	}

}
