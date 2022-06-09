package useClasses;


import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilityClasses.CommonExtentReporter;

@Listeners(baseClasses.Listener.class)

public class TestIncludeExcludeAndGroups extends CommonExtentReporter {
	
@BeforeClass
public void beforeClass()
{
	test=reporter.createTest("TestIncludeExcludeAndGroups");	
}
	  
	@Test(invocationCount=3,priority=2)
	  public void A() { 
		  Reporter.log(" TestIncludeExcludeAndGroups:A Method is called",true);
		 // Assert.fail("for fun");
	  }
	  @Test(priority=-6)
	  public void B() {
		  Reporter.log("TestIncludeExcludeAndGroups :B Method is called",true);
	  }
	  
	  @Test(priority=-6,dependsOnMethods= {"A"})
	  public void C() {
		  Reporter.log("TestIncludeExcludeAndGroups:C Method is called",true);
	  }
	  
	  @Test(priority=-1)
	  public void D() {
		  Reporter.log("TestIncludeExcludeAndGroups:D Method is called",true);
	  }
	  @Test()
	  public void E() {
		  Reporter.log("TestIncludeExcludeAndGroups: E Method is called",true);

}
	 
}
