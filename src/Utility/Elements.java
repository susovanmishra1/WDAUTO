package Utility;

import org.openqa.selenium.By;

public class Elements {
	/**
	 * Created by Rajiv
	 */

	public static By findbutton = By.xpath("//a[@id='filterPanelFindButton']//span");
	public static By findtext = By.xpath("//input[contains(@id,'CULL_TEXT')]");
	public static By OkButton = By.xpath("//div[@id='btnOK']");
	public static By statusforprj = By.xpath("//div[@class='project-details-left']");
	// a[@href="javascript:parent.loadAllAvail();"]
	//
	// public static By select =
	// By.xpath("//table[@id='datatable']//tbody/tr[1]");
	public static By select = By
			.xpath("//table[@id='datatable']//tbody//tr[not(contains(@style,'display: none'))]//th");
	public static By closeselect = By.xpath("//img[@name=\"autoCompleteDialogXButton\"]");

	// public static By select = By.xpath("//tr[@class=\"list-coldata-leftalign
	// acEvenRow\"]");

	public static By help = By.xpath("//img[@alt=\"Help\"]");
	public static By help_expand = By.xpath("//img[contains(@src,\"Closed\")]");

	// Workday Login
	public static By workday_username = By.xpath("//input[@aria-label='Username']");
	public static By workday_Password = By.xpath("//input[@aria-label='Password']");
	public static By workday_SignInButton = By.xpath("//button[text()='Sign In']");
	public static By workday_Entercode = By.xpath("//*[text()='Use a security code to sign in']");
	public static By Code = By.xpath("//*[@placeholder='Security Code']");
	public static By Sendotp = By.xpath("//input[@id='vipSubmitOTP']");

	// Dtrace Home - searchbox && Searchbuton
	public static By workday_globalSearchbox = By.xpath("//input[@data-automation-id='globalSearchInput']");
	public static By workday_searchicon = By.xpath("//span[@class='css-d6ok76']");
	public static By workday_searchresult = By.xpath("//div[@data-automation-id='pex-search-result-header']");
	public static By workday_IS = By.xpath("//div[text() = 'Integration System']");
	public static By workday_IntigrationeventStatau = By.xpath("(//input[@dir= 'ltr'])[2]");
	public static By workday_Ok = By.xpath("//span[@title= 'OK']");
	//div[@title= 'INT055-RequisitionDetails-WD-DXCDD - 21/12/2021, 3:48:08.948 AM (Completed)']
	//div[@id= 'promptOption-gwt-uid-77']
//	public static By workday_IEvents = By.xpath("//div[@id= 'promptOption-gwt-uid-77']");
	
	public static By Integration_Events = By.xpath("//div[@title='INT055-RequisitionDetails-WD-DXCDD - 27/12/2021, 1:59:57.866 AM (Completed)']");
	
	
	//div[@id='promptOption-gwt-uid-233']
//	div[@title ='Completed']
	//div[@title ='Failed']
	
	public static By IntegrationSystems = By.xpath("(//div[@title='INT055-RequisitionDetails-WD-DXCDD'])[1]");
			
	public static By workday_StatusCompleted = By.xpath("(//div[text()='Completed'])[1]");
//	(//div[text()='Completed With Errors'])[1]
	
  public static By CompletedwithErrorvalue = By.xpath("//div[text()='Completed With Errors']");
			
	
	public static By workday_Statusfailed = By.xpath("(//div[@title ='Failed'])[1]");
	
	public static By Integration_EventsFailed = By.xpath("//div[@title='INT055-RequisitionDetails-WD-DXCDD - 11/06/2020, 10:00:07.778 AM (Failed)']");
	
	public static By workday_Ok1 = By.xpath("(//span[text()='OK'])");
	public static By workday_EventStatus = By.xpath("//input[@class='css-164y91d-InputContainer edt0qdt22'][1]");
//	public static By workday_EventStatusFailed = By.id("(//input[@class='css-1c607ry-CheckboxInput efo3j1r3'])[5]");
	
	public static By workday_EventStatusFailed = By.id("//div[.='Failed']/preceding-sibling::div[@data-automation-id='checkbox']");
	//div[.='Completed With Errors']/preceding-sibling::div[@data-automation-id='checkbox']
	public static By workday_EventStatusCompletedwithError = By.id("//div[.='Completed With Errors']/preceding-sibling::div[@data-automation-id='checkbox']");

	public static By workday_StatusFailed = By.xpath("//div[@data-automation-label='Failed']");

	public static By ClickMessage = By.xpath("(//div[text()='Messages (2)'])[1]");
//	Integration Event Status
	
	public static By CompletedwithError = By.xpath("//*[text()='Completed With Errors']");
	public static By OutputFiles  = By.xpath("(//div[text()='Output Files (1)'])[1]");
//	(//div[@data-automation-id='fileAttachment'])[1]/div/div
	//div[@data-automation-id='fileAttachment']
	public static By OutputFilesLink  = By.xpath("//div[@data-automation-id='fileAttachment']");
	
	public static By CompletedWithError = By.xpath("//div[@title='INT00360F - National Identifier - EIB - Outbound - 25/06/2019, 6:00:04.372 AM (Completed With Errors)']");
	
	
	public static By CompletedwithErrorMessage  = By.xpath("//div[@class='gwt-Label WEDP WNBP' and @data-automation-id='promptOption' and @id='promptOption-gwt-uid-53']");
	//div[@class='gwt-Label WFDP WOBP' and @data-automation-id='promptOption' and @id='promptOption-gwt-uid-90']
	
//TC6
	
	public static By WDDXCDD6 = By.xpath("//a[@href='/dxctechnology3/d/inst/1$625/625$1400.htmld']");
	public static By VerifyCloudCollection = By.xpath("(//div[@data-automation-id='promptOption'])[2]");
	
//TC7
	
	public static By IService = By.xpath("(//a[@href='/dxctechnology3/d/inst/1$625/625$1400.htmld'])[1]");
	public static By IServiceLink = By.xpath("//div[@title='INT055-RequisitionDetails']");

	
//	public static By Iservicelink = By.xpath("//div[@aria-label='INT055-RequisitionDetails'])[1]");
	public static By RPT1 = By.xpath("(//div[@class='WK1T WB1T WAAB WKP3'])[1]");
	public static By RPT2 = By.xpath("(//div[@class='WK1T WB1T WAAB WKP3'])[2]");
	
//	TC8:
	//div[@class='gwt-Label WA01'])[3]
//	public static By BusinessProcess = By.xpath("(//div[@class='gwt-Label WA01'])[3]");
//	public static By BusinessProcess = By.xpath("//div[@class='WM-1'])[1]");
	//div[contains(text(),'Business Process Definitions')]
	public static By BusinessProcess = By.xpath("//div[contains(text(),'Business Process Definitions')]");
	//div[@title='Integration Process Event for INT055-RequisitionDetails-WD-DXCDD (TOP LEVEL)']
	public static By BusinessProceeDefination = By.xpath("//div[@title='Integration Process Event for INT055-RequisitionDetails-WD-DXCDD (TOP LEVEL)']");
	public static By INT055RequisitionDetails = By.xpath("//div[@data-automation-id='pex-search-result-header']");

//	TC9
	public static By Magnifiericon = By.xpath("(//img[@class='gwt-Image WMTQ WOBS WLDS WNVO WHCP']//parent::li[position()=1])[3]");
	
	public static By SFTP = By.xpath("(//div[@class='gwt-Label WGDP WPBP'])[10]");
//	(//div[@class='gwt-Label WGDP WPBP'])[11]
	public static By SFTPPROAddress = By.xpath("//span[text()='sftp://sftp-wd-pro.itcs.houston.dxc.technology:8183']");
	
	public static By SFTPITGAddress = By.xpath("//span[text()='sftp://sftp-wd-itg.itcs.houston.dxc.technology:8183']");
	// EIB TC // EIB TC// EIB TC// EIB TC// EIB TC// EIB TC// EIB TC// EIB TC// EIB TC// EIB TC// EIB TC
	
	public static By INT00360FNationalIdentifierEIBOutbound = By.xpath("//a[@class='css-w1vlbn-link-css']");
	public static By VerifyIntigrationSystems = By.xpath("(//div[@title='INT00360F - National Identifier - EIB - Outbound'])[1]");
//	public static By Integration_EventsEIB = By.xpath("div[@title='INT00360F - National Identifier - EIB - Outbound - 05/10/2021, 6:01:14.644 AM (Completed)']");
	public static By Integration_EventsEIB = By.xpath("//div[@title='INT00360F - National Identifier - EIB - Outbound - 05/10/2021, 6:01:14.644 AM (Completed)']");
	//EIB TC---TC3
	public static By Integration_EventsFailedEIB = By.xpath("//div[@title='INT00360F - National Identifier - EIB - Outbound - 10/06/2021, 6:04:49.568 AM (Failed)']");
//	INT00360F - National Identifier - EIB - Outbound - 10/06/2021, 6:04:49.568 AM (Failed)
	public static By workday_StatusfailedEIB = By.xpath("(//div[@title ='Failed'])[1]");
	public static By ClickEIBMessage = By.xpath("(//div[text()='Messages (2)'])[1]");
	public static By FailedwithEIBErrorMessgae = By.xpath("//div[@title='Terminating failed job']");
	public static By FailedwithEIBErrorMessgae2 = By.xpath("//div[@title='Workday is aborting this slow-running custom report to protect the reporting resources for your tenant. Access the Edit Report Performance Log Settings task to log the report, then access the View Report Performance Logs task and click the View button to identify areas for improvement.']");
//	TC4
	public static By CompletedwithEIBErrorMessage  = By.xpath("//div[@title='INT00360F - National Identifier - EIB - Outbound - 25/06/2019, 6:00:04.372 AM (Completed With Errors)']");
	
	public static By EIBStatusCompletedwithError = By.xpath("(//div[text()='Completed With Errors'])");
	public static By EIBCompletedWithError = By.xpath("//div[@title='INT00360F - National Identifier - EIB - Outbound - 25/06/2019, 6:00:04.372 AM (Completed With Errors)']");
//	public static By EIBfullErrorMessage = By.xpath("//div[contains(@id,'promptOption-gwt-uid-109') or @id='promptOption-gwt-uid-53']");
	
	public static By EIBfullErrorMessage = By.xpath("(//div[contains(@id,'promptOption-gwt-uid')])[35]");
	
//	EIB-TC5
	
	public static By EIBIntegration_Events = By.xpath("(//div[contains(@id,'promptOption-gwt-uid')])[29]");
	
	public static By EIBOutputFilesLink  = By.xpath("//div[@title='wkd_hrd_ghr0360.dat']");
	
//	EIB -TC6
	
	public static By EIBOutboundLink  = By.xpath("//a[@class='css-1dwd85b']");
	public static By VerifyDataSource  = By.xpath("//div[contains(text(),'RPT - INT00360F - Personal NID Data from WD-HRDD')]");
	//EIB-TC7
	
	public static By IntigrationSystemLink  = By.xpath("//a[@class='css-1dwd85b']");
	public static By TransformationType = By.xpath("//div[text()='Custom Transformation']");
	public static By TransformationExce = By.xpath("//div[@title='INT00360F_SMO11 (INT00360F_Personal NID Data_IMO_ver1 (1).xsl)']");
//	EIB-TC8
//	(//div[contains(@class,'wd-Text WAL2 WFL2 WAAB')])[1]
	public static By SFTPLink  = By.xpath("(//div[contains(@class,'wd-Text WAL2 WFL2 WAAB')])[1]");
//	EIB-TC9
	//div[contains(@id,'56$361494--uid22')]

	public static By SFTPAddress  = By.xpath("//span[contains(text(),'sftp://sftp-wd-itg.itcs.houston.dxc.technology:8183')]");
//	EIB -TC10	
	public static By SFTPDirectory  = By.xpath("(//span[contains(text(),'/opt/tibco/sftp/client_shared/EVT/outbound')])[1]");
//  EIB-TC11
	
	public static By TEMPFile  = By.xpath("(//div[contains(@class,'wd-Text WAL2 WFL2 WAAB')])[4]");
	
	public static By SSHAuthentication  = By.xpath("(//div[contains(@class,'wd-Text WAL2 WFL2 WAAB')])[5]");
//  EIB-TC12
	public static By UserId  = By.xpath("(//div[contains(@class,'wd-Text WAL2 WFL2 WAAB')])[6]");
//	EIB-TC13
	public static By AuthenticationKeyPair  = By.xpath("(//div[contains(@class,'wd-Text WAL2 WFL2 WAAB')])[7]");
	//
//	EIB-TC14
	//div[contains(@class,'wd-Text WAL2 WFL2 WAAB')])[8]
	public static By correctFilename  = By.xpath("(//div[contains(@class,'wd-Text WAL2 WFL2 WAAB')])[8]");
//	EIB-TC15
	public static By EncryptUsing  = By.xpath("(//div[contains(@title,'SaFTT_PGP_Key')])[1]");

//	EIB-TC16
//	(//div[@class='WJFG'])[28]    (//div[@class='WJFG'])[27]    (//div[@class='WJFG'])[26]

	}	


