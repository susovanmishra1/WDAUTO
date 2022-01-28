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

import FuntionsINT055WDDXCDD.FunctionINT055TC005VerifystatusCompletedwithoutput;

import java.io.IOException;

public class INT00360TC0012VerifyconfiguredwithcorrectUserId {
	/**
	 * Created by
	 */
	GenericLib gl = new GenericLib(this.getClass().getSimpleName());

   @DataProvider
	public Object[][] data(ITestContext context) throws BiffException, IOException {
		ExcelLib xl = new ExcelLib("TC12VerifyConfiWithCorrectUID", "TC001");
		return xl.getTestdata();
	}

	@BeforeMethod
	public void loginRun() throws Exception {
//		Funtions.FunctionINT055TC003VerifystatusFailed wday3 = new Funtions.FunctionINT055TC003VerifystatusFailed();
//		INT055TC005VerifystatusCompletedwithoutputfiles
		FuntionsINT00360FEIBOutbound.FunctionINT00360TC0012VerifyConfigurewithCorrectUserId wday12 = new FuntionsINT00360FEIBOutbound.FunctionINT00360TC0012VerifyConfigurewithCorrectUserId();
		wday12.beforemethod();
		wday12.Login();
	}

	@Test(dataProvider = "data")
	public void searchPositionFromExcel(String Intigration_ID,String Status) throws Exception {
		FuntionsINT00360FEIBOutbound.FunctionINT00360TC0012VerifyConfigurewithCorrectUserId wday12 = new FuntionsINT00360FEIBOutbound.FunctionINT00360TC0012VerifyConfigurewithCorrectUserId();
		wday12.beforemethod();
		wday12.VerifyConfigurewithCorrectUserId(Intigration_ID,Status);
		
	}

	@AfterMethod
	public void afterend() {
		FuntionsINT00360FEIBOutbound.FunctionINT00360TC0011VerifyCorrectAuthenticationMethode wday12 = new FuntionsINT00360FEIBOutbound.FunctionINT00360TC0011VerifyCorrectAuthenticationMethode();
		wday12.beforemethod();
		wday12.afterMethod();
	}

}
