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

public class INT0360FTC004VerifystatusCompletedwithError {
	/**
	 * Created by
	 */
	GenericLib gl = new GenericLib(this.getClass().getSimpleName());

   @DataProvider
	public Object[][] data(ITestContext context) throws BiffException, IOException {
		ExcelLib xl = new ExcelLib("TC004VerifyStatusCompleWithErr", "TC001");
		return xl.getTestdata();
	}

	@BeforeMethod
	public void loginRun() throws Exception {
		FuntionsINT00360FEIBOutbound.FunctionINTOO360FETC004VerifystatusCompletedwithError wday3 = new FuntionsINT00360FEIBOutbound.FunctionINTOO360FETC004VerifystatusCompletedwithError();
		wday3.beforemethod();
		wday3.Login();
	}

	@Test(dataProvider = "data")
	public void searchPositionFromExcel(String Intigration_ID,String Status,String Messages) throws Exception {
		FuntionsINT00360FEIBOutbound.FunctionINTOO360FETC004VerifystatusCompletedwithError wday4 = new FuntionsINT00360FEIBOutbound.FunctionINTOO360FETC004VerifystatusCompletedwithError();
		wday4.beforemethod();
		wday4.VerifystatusCompletedwithError(Intigration_ID,Status,Messages);
	}

	@AfterMethod
	public void afterend() {
		FuntionsINT00360FEIBOutbound.FunctionINTOO360FETC004VerifystatusCompletedwithError wday = new FuntionsINT00360FEIBOutbound.FunctionINTOO360FETC004VerifystatusCompletedwithError();
		wday.beforemethod();
		wday.afterMethod();
	}

}
