package useClasses;

import org.testng.annotations.Test;

import baseClasses.BaseClass;

import pomClasses.HomePage;
import pomClasses.LoginPage;
import utilityClasses.UtilityClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Test_CheckLogin extends UtilityClass {
	private WebDriver driver;
	HomePage hp;
	 
	  @Parameters("browser")
	  @BeforeClass
	  public void beforeClass(String browser1) throws InterruptedException {
		  Reporter.log("Test_CheckLogin :Browser name is populated "+browser1,true);
		   driver=BaseClass.getDriver(browser1);
		   Reporter.log("Test_CheckLogin :Driver initiated.",true);
	  }

	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  LoginPage lp=new LoginPage(driver);
			lp.putEmail();
			lp.putPassward();
			UtilityClass.takeScreenshot(driver,this.getClass().getName());
			lp.clickLoginButton();
			Reporter.log("Test_CheckLogin :Login is complete",true);
			Thread.sleep(3000);
			
	  }
	  
  @Test
  public void checkProfile() {
	 hp =new HomePage(driver);
	  
	  Assert.assertTrue(hp.isLoginSuccessfull());
	  
	  Reporter.log("Test_CheckLogin :Profile is Loaded.",true);
	  
  }
  

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  hp.logout(driver);
	  
	  //driver.navigate().to("https://www.flipkart.com/");
	  Reporter.log("Test_CheckLogin :After method",true);
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
