package useClasses;

import org.testng.annotations.Test;

import baseClasses.BaseClass;

import pomClasses.HomePage;
import pomClasses.LoginPage;
import utilityClasses.CommonExtentReporter;

import utilityClasses.UtilityClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;

import org.testng.annotations.BeforeClass;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
 
public class Test_CheckLogin extends CommonExtentReporter {
	
	HomePage hp;
	 
	@BeforeTest
	  public void beforeTest()
	  {
		  
		  
		 
	  }
	
	  @Parameters("browser")
	  @BeforeClass
	  public void beforeClass(String browser1) throws InterruptedException {
		  Reporter.log("Test_CheckLogin :Browser name is populated "+browser1,true);
		   driver=BaseClass.getDriver(browser1);
		   Reporter.log("Test_CheckLogin :Driver initiated.",true);
		   test=reporter.createTest("Test_CheckLogin");
	  }

	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  
			
	  }
	
 
  @Test
  public void  checkProfile() throws Exception {
	  LoginPage lp=new LoginPage(driver);
		lp.putEmail();
		lp.putPassward();
		UtilityClass.takeScreenshot(driver,this.getClass().getName());
		lp.clickLoginButton();
		Reporter.log("Test_CheckLogin :Login is complete",true);
		Thread.sleep(3000);
	 hp =new HomePage(driver);
	  
	  Assert.assertTrue(hp.isLoginSuccessfull());
	  
	  Reporter.log("Test_CheckLogin :Profile is Loaded.",true);
	  
	  
  }
  

    
  @AfterClass
  public void afterClass() {
	  Reporter.log("Test_CheckLogin :Driver closed.",true);
	  try
	  {
	  driver.quit();
	  }catch(Exception e)
	  {}
  }
}
