package TESTINT055WDDXCDD;

import static org.apache.commons.lang.StringUtils.isBlank;

import Utility.ExcelLib;
import Utility.GenericLib;
import jxl.read.biff.BiffException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import FuntionsINT055WDDXCDD.FunctionINT055TC005VerifystatusCompletedwithoutput;

import java.io.IOException;

public class INT055TC0010VerifystatusSFTPAddress {
	/**
	 * Created by
	 */
	GenericLib gl = new GenericLib(this.getClass().getSimpleName());

   @DataProvider
	public Object[][] data(ITestContext context) throws BiffException, IOException {
		ExcelLib xl = new ExcelLib("VerifystatusSFTPAddress10", "TC001");
		return xl.getTestdata();
	}
   
//	FuntionsINT055WDDXCDD.FunctionINT055TC0010VerifystatusSFTPAddress wday10 = new FuntionsINT055WDDXCDD.FunctionINT055TC0010VerifystatusSFTPAddress();

	@BeforeMethod
	public void loginRun() throws Exception {
		FuntionsINT055WDDXCDD.FunctionINT055TC0010VerifystatusSFTPAddress wday10 = new FuntionsINT055WDDXCDD.FunctionINT055TC0010VerifystatusSFTPAddress();
		wday10.beforemethod();
		wday10.Login();
	}

	@Test(dataProvider = "data")
	public void searchPositionFromExcel(String Intigration_ID,String Status,String Status1) throws Exception {
		FuntionsINT055WDDXCDD.FunctionINT055TC0010VerifystatusSFTPAddress wday10 = new FuntionsINT055WDDXCDD.FunctionINT055TC0010VerifystatusSFTPAddress();
		
		wday10.beforemethod();
		wday10.verifyConfigSFTPAddress(Intigration_ID,Status,Status1);
		
	}

	@AfterMethod
	public void afterend() {
		FuntionsINT055WDDXCDD.FunctionINT055TC0010VerifystatusSFTPAddress wday = new FuntionsINT055WDDXCDD.FunctionINT055TC0010VerifystatusSFTPAddress();
		wday.beforemethod();
		wday.afterMethod();
	}

}
