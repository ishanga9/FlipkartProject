package utilityClasses;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CommonExtentReporter extends UtilityClass {
	public static ExtentHtmlReporter htmlre;
	public static ExtentReports reporter;
	public static ExtentTest test;
	
	@BeforeSuite
    public void getExtentReporter()
	{
	ExtentHtmlReporter htmlre=new ExtentHtmlReporter("ExtentReporter.html");
	reporter =new ExtentReports();
	reporter.attachReporter(htmlre);
	
 	}
	
	@AfterMethod
	  public void afterMethod(ITestResult result) throws Exception {
		
		  if(result.getStatus()== ITestResult.SUCCESS)
		  {
			test.log(Status.PASS, "Test is pass "+result.getInstanceName()+" "+result.getName());
		  }
		  else
		  {
			 String path=screenshotRobot(result.getName());
			  test.log(Status.FAIL, "Test is fail "+result.getInstanceName()+" "+result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		  }
		  Reporter.log("Test_EtoE_BuyProduct :After method",true);
	  }
	
	@AfterSuite
	public void flushReporter()
	{
		reporter.flush();
	}
	
}
