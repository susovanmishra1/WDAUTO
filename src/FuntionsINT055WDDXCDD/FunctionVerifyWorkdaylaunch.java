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

public class FunctionVerifyWorkdaylaunch extends BaseClass {
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
		Thread.sleep(2000);
//		gl.inputText(Elements.workday_Password, "workday_Password",config.getProperty("Password"));
		Thread.sleep(2000);
//		gl.ClickButton(Elements.workday_SignInButton, "workday_SignInButton");
//		gl.clickElement(Elements.workday_SignInButton, "workday_SignInButton");
		gl.inputText(Elements.workday_username, "workday_username",config.getProperty("UserName"));
		gl.inputText(Elements.workday_Password, "workday_Password",config.getProperty("Password"));
		gl.clickElement(Elements.workday_SignInButton, "workday_SignInButton");
		Thread.sleep(10000);
		
		
	}

	public void searchPosition(String Intigration_ID) throws Exception {

		JSWaiter.setDriver(driver);
		JSWaiter jsw = new JSWaiter();
		jsw.waitAllRequest();
		Thread.sleep(2000);
		
//		gl.ClickButton(Elements.workday_searchicon, "workday_searchicon");
		gl.clickElement(Elements.workday_searchicon, "workday_search icon");
		Thread.sleep(2000);
//		gl.inputTextandTab(Elements.workday_globalSearchbox, "workday_globalSearchbox", "Position_ID");
		gl.inputText(Elements.workday_globalSearchbox, "PLM_ID",Intigration_ID);
		Thread.sleep(2000);
		gl.clickElement(Elements.workday_searchicon, "workday_searchicon");

//		gl.ClickButton(Elements.workday_searchicon, "workday_searchicon");
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//button[@data-automation-id='pex-related-actions']")).click();
//		driver.findElement(By.xpath("//div[@data-automation-id='pex-search-result-header']")).click();
//		
	
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='Skip to main content']/span[1]")).click();
		Thread.sleep(3000);
		/*WebElement ele2 = driver.findElement(By.xpath("//div[@data-automation-id='pex-search-result-header']/h4"));
		act.moveToElement(ele2).click().build().perform();
		WebElement ele3 = driver.findElement(By.xpath("//div[text()='Integration System']"));
		WebElement ele4 = driver.findElement(By.xpath("//div[@data-clipboard-text='Integration Events']"));
		act.moveToElement(ele3).build().perform();
		act.moveToElement(ele4).click().build().perform();
		*/
		
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		WebElement ele3 = driver.findElement(By.xpath("//div[text()='Integration System']"));
		act.moveToElement(ele3).build().perform();
		WebElement ele4 = driver.findElement(By.xpath("//div[text()='Integration Events']"));
		act.moveToElement(ele4).click().build().perform();
		Thread.sleep(3000);
		WebElement ele5 = driver.findElement(By.xpath("///button[@id='d080c80321044910883d8216bc5d62a5']/span[2]"));
		ele5.click();
		//gl.ClickButton(Elements.workday_searchresult, "workday_searchresult");
		//Thread.sleep(8000);
		//driver.findElement(By.xpath("//div[@id='wd-PageHeader-NO_METADATA_ID-uid4']/div[1]")).click();
		Thread.sleep(2000);
		

		
		//gl.ClickButton(Elements.button_Close, "Close Button");
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
