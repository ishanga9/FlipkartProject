package useClasses;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class groupseg1 {
	@Test(groups = "regression")
	  public void TC1()	  
	  {
		  Reporter.log("TC1 regression Running",true);
	  }
	  
	  @Test(groups = "sanity")
	  public void TC2()
	  
	  {
		  Reporter.log("TC2 sanity Running",true);
	  }
	  
	  @Test(groups = "regression")
	  public void TC3()
	  
	  {
		  Reporter.log("TC3 regression Running",true);
	  }
	  
	   @Test(groups = "sanity")
	  public void TC4()
	  
	  {
		  Reporter.log("TC4 sanity Running",true);
	  }
	  
	  @Test
	  public void TC5()
	  
	  {
		  Reporter.log("TC5 Running",true);
	  }

}
