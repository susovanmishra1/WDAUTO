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

import FuntionsINT055WDDXCDD.FunctionINT055TC002VerifyStatusCompleted;

import java.io.IOException;

public class INT055TC002VerifyStatusCompleted {
	/**
	 * Created by
	 */

	GenericLib gl = new GenericLib(this.getClass().getSimpleName());

   @DataProvider
	public Object[][] data(ITestContext context) throws BiffException, IOException {
		ExcelLib xl = new ExcelLib("IntegrationName", "TC001");
		return xl.getTestdata();
	}

	@BeforeMethod
	public void loginRun() throws Exception {
		FuntionsINT055WDDXCDD.FunctionINT055TC002VerifyStatusCompleted wday2 = new FuntionsINT055WDDXCDD.FunctionINT055TC002VerifyStatusCompleted();
		wday2.beforemethod();
		wday2.Login();

	}

	@Test(dataProvider = "data")
	public void searchPositionFromExcel(String Intigration_ID,String Status) throws Exception {
		FuntionsINT055WDDXCDD.FunctionINT055TC002VerifyStatusCompleted wday = new FuntionsINT055WDDXCDD.FunctionINT055TC002VerifyStatusCompleted();
		wday.beforemethod();
		wday.VerifyStatusCompleted(Intigration_ID,Status);

	}

	@AfterMethod
	public void afterend() {
		FuntionsINT055WDDXCDD.FunctionINT055TC002VerifyStatusCompleted wday = new FuntionsINT055WDDXCDD.FunctionINT055TC002VerifyStatusCompleted();
		wday.beforemethod();
		wday.afterMethod();
	}

}
