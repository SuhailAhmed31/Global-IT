package testScenario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import testObjectRepository.Global_IT_Page;
import testObjectRepository.Home_page;
import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ExcelUtility;
import userDefinedLibraries.ExtentReportsForProject;
import userDefinedLibraries.ScreenShot;

public class Global_IT {
    
	WebDriver driver;
	JavascriptExecutor js;
	Home_page hp;
	Global_IT_Page gp;
	ExcelUtility excel;
	List<WebElement> newsHeadersList;
	int i;
	ExtentReports extent;
	ExtentTest test;
	ExtentReportsForProject extreportobj = new ExtentReportsForProject();
	String screenshotPath;
	String dataPath;
	int k=1;
	int a=1;
	@Parameters({ "browser" }) 
	@BeforeClass
	public void driverConfig(String browser) {
		// Instantiate driver
		driver=DriverSetup.driverInstantiate(browser);
		System.out.println(browser+" browser opened with the provided url");
		
		extent = extreportobj.setExtentReport();
		System.out.println("Report object Initialised");

		js=(JavascriptExecutor)driver;
		gp=new Global_IT_Page(driver);
		hp=new Home_page(driver);
		
		dataPath=System.getProperty("user.dir")+"\\testData\\OutputData.xlsx";
		excel=new ExcelUtility(dataPath);
		
	}
	

  @Test(priority=0)
  public void captureUserInfo() {
	  
	  test = extent.createTest("To capture user info");
	  test.log(Status.INFO, "Starting the test case");
	   hp.clickOnUserInfo();
	   ScreenShot.getScreenShot(driver,"UserInfo.png");
	  
	   String userName=hp.userName.getText();
	   String userEmail=hp.userEmail.getText();
	   
	   //storing userInfo in excel sheet
	   excel.writeData(dataPath,"Sheet1", 1, 1, userName);
	   excel.writeData(dataPath,"Sheet1", 2, 1, userEmail);
	   
	  
	   System.out.println(userName);
	   System.out.println(userEmail);
	   
	   test.pass("UserInfo captured");
	   
   }
    
  @Test(priority=1)
  public  void clickOnIT() {
	  
	  test = extent.createTest("To click on IT");
	  
	  hp.clickOnCorporateFunctions();
	  
	  test.log(Status.INFO,"Clicked 'Corporate Functions'");
	  hp.mouseOverOnSecurityAndTechnology();
	    
      test.log(Status.INFO,"mouse hovered on 'SecurityAndTechnology'");
      
	  hp.clickOnIT();
	  test.log(Status.INFO,"Clicked 'IT'");
	 
	  test.pass("Test passed");
	  System.out.println("Report for clicking corporate functions and IT is generated");
	   }
  
    @Test(priority=2)
    public void exploreApps() throws InterruptedException {
        
    	test = extent.createTest("To explore other apps in Global IT page");
    	gp.exploreApps();
    	test.pass("Explored all other apps in Global IT page");
    	 System.out.println("Report for exploring other apps in Global IT page  is generated");
    }
    @Test(priority=3,dataProvider="titles")
   public  void validateApps(String expct_title,String appName)  {
    	test = extent.createTest("To validate other apps in Global IT page");
    	String s=gp.app.get(i);
    	i++;
    	Assert.assertEquals(s, expct_title);
    	test.pass(appName+" is validated ");
    	 System.out.println("Report for validating "+appName+" app in Global IT page is generated");
    }
    
    @Test(priority=4)
   public  void verifyNewsAvailability() {
    	test = extent.createTest("To verify IT_News ");
    	
    	js.executeScript("arguments[0].scrollIntoView();",gp.apps.get(0));
    	
    	test.log(Status.INFO,"Scrolled down to see IT News section is displayed or not.");
    	WebElement IT_News=gp.IT_News;
    	
    	boolean news=IT_News.isDisplayed();
    	try {
    		//Taking screenshot
    	  ScreenShot.getScreenShot(driver,"IT_News.png");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	test.createNode(" IT_News is Present");
    	
    	Assert.assertEquals(news,true);
    	
    	test.pass("Test Passed");
    	 System.out.println("Report for IT News availability section is generated");
    }
    
    @Test(priority=5)
    void verifyAwardsAvailability() {
    	test = extent.createTest("To verify IT_Awards");
    	
    	js.executeScript("arguments[0].scrollIntoView();",gp.awardsView);
    	
    	test.log(Status.INFO,"Scrolled down to see IT Awards section is displayed or not.");
    	
    	WebElement IT_Awards=gp.IT_Awards;
    	
    	boolean awards=IT_Awards.isDisplayed();
    	try {
    		
    	  //Take screenshot
    	  ScreenShot.getScreenShot(driver,"IT_Awards.png");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	test.createNode(" IT_Awards is Present");
    	Assert.assertEquals(awards,true);
    	test.pass("Test Passed");
    	System.out.println("Report for IT Awards availability section is generated");
    	
    }
    
    @Test(priority=6)
    void displayNewsCount() {
    	test = extent.createTest("To print news count");
    	js.executeScript("arguments[0].scrollIntoView();",gp.IT_News);
    	newsHeadersList=gp.newsHeadersList;
    	int cnt=newsHeadersList.size();
    	
    	System.out.println("News headers count is "+cnt);
    	
    	//storing news count in excel sheet
    	excel.writeData(dataPath,"Sheet1", 1, 2,String.valueOf(cnt));
    	
    	test.pass("News count printed");
    	
    }
    
    @Test(priority=7)
    void validateNewsHeaderAndTooltip() {
    	test = extent.createTest("To validate newsheaders and tooltips ");
    	for(WebElement w:newsHeadersList) {
			String header=w.getText();
			String tooltip=w.getAttribute("title");
			Assert.assertEquals(header, tooltip);
		}
    	test.pass("Newsheaders and their tooltips are matched");
    	System.out.println("Report for validate news header and tooltip is generated");
    }
	@Test(priority=8,dataProvider="awards")
			
	 void displayAwards(String a) throws InterruptedException {
		   
	        	test = extent.createTest("To display all awards information ");
				String s="";
				
				js.executeScript("arguments[0].scrollIntoView();",gp.awards1);
				
				driver.findElement(By.linkText(a)).click();
				
				test.log(Status.INFO, "Clicked awardLink");
				Thread.sleep(10000);
				
				List<WebElement> deslist=gp.descriptionsList;
				try {
				   //Take screenshot
				   ScreenShot.getScreenShot(driver, "awards"+k+".png");
				}catch(Exception e) {
					e.printStackTrace();
				}
						
				for(WebElement d:deslist) {
					s=s+d.getText();
					
				}
				System.out.println(s);
				
				//storing description in excel sheet
				excel.writeData(dataPath,"Sheet2", k, 1,s);
				
				
				//Navigate back to Global IT page
				driver.navigate().back();
				Thread.sleep(5000);
				test.pass("Displayed all awards information");
				System.out.println("Report for award "+k+" description is generated");
				k++;
	 }
	
	@AfterMethod
	public void getResult(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			// To capture screenshot path and store the path of the screenshot in the string
			// "screenshotPath"
			// We do pass the path captured by this method in to the extent reports using
			// "logger.addScreenCapture" method.
			screenshotPath = ScreenShot.getScreenShot(driver, "TestCaseFailed"+a+".png");
			a++;
			// To add it in the extent report
			test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			screenshotPath = ScreenShot.getScreenShot(driver, "TestCasePassed"+a+".png");
			test.pass("Test Case Passed snapshot is below"+test.addScreenCaptureFromPath(screenshotPath));
			a++;
		}
	}

	@AfterMethod(dependsOnMethods = "getResult")
	public void endReport() {
		// write results into the file
		extreportobj.endExtentReport();
		

	}

	@AfterClass
	public void closeBrowser() {
		// Close the browser after all the steps of scenario
		DriverSetup.driverTearDown();
		System.out.println("Closed the browser");
	}
	
    @DataProvider(name="awards")
	String[][] awardsInfo() {
        String path=".\\testData\\Data.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet2");	
		int totalcols=xlutil.getCellCount("Sheet2",1);
		
		String[][] awards=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{	
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				awards[i-1][j]= xlutil.getCellData("Sheet2",i, j);  //1,0
			}
			
		}
		
		return awards;
    }
    
    @DataProvider(name="titles")
	public String[][] getTitles(){
		String path=".\\testData\\Data.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String[][] titles=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{	
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				titles[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
			
		}
		
		return titles;
		
	}
}
