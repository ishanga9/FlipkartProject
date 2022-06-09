package utilityClasses;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReports_Exa extends UtilityClass{

	
	public static ExtentReports getExtentReporter()
	{
	ExtentHtmlReporter htmlre=new ExtentHtmlReporter("screenshotImages\\ExtentReports_Test.html");
	ExtentReports reporter =new ExtentReports();
	reporter.attachReporter(htmlre);
	return reporter;
	}
}
