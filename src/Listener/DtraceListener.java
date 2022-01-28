package Listener;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class DtraceListener extends TestListenerAdapter {

	@Override
	public void onTestSuccess(ITestResult tr) {
				
		super.onTestSuccess(tr);
		Object[] params = tr.getParameters();
		String a = (String) params[0];
		String line1 = "*****FAILED*****" +tr.getMethod().getMethodName();
		Reporter.log(line1);
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		String line1 = "PASSED-->" +tr.getMethod().getMethodName();
		Reporter.log(line1);

	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestFailedButWithinSuccessPercentage(tr);
	}

	@Override
	public void onStart(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onStart(testContext);
	}

	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		super.onTestStart(result);
	}
	

}
