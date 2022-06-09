package useClasses;

import org.testng.Assert;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import baseClasses.Listener;


import utilityClasses.CommonExtentReporter;


public class TNG_keywords extends CommonExtentReporter{
	
	@BeforeClass
	public void beforeClass()
	{
		test=reporter.createTest("TNG_keywords");	
	}

	  
	  
  @Test
  public void A() {
	  Reporter.log(" A Method is called",true);
	  Assert.fail("for fun");
  }
  @Test(priority=0)
  public void B() {
	  Reporter.log("B Method is called",true);
  }
  
  @Test(priority=0,dependsOnMethods= {"A"})
  public void C() {
	  Reporter.log("C Method is called",true);
  }
  
  @Test(priority=0)
  public void D() {
	  Reporter.log("D Method is called",true);
  }
  @Test()
  public void E() {
	  Reporter.log(" E Method is called",true);
	  //Assert.fail();
  }
  
 
  
}
