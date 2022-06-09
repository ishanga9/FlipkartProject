package useClasses;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class groupseg2 {
	@Test (groups = "regression")
	  public void TC6()
	  
	  {
		  Reporter.log("TC6 regression Running",true);
	  }
	  
	  @Test(groups = "sanity")
	  public void TC7()
	  
	  {
		  Reporter.log("TC7 sanity Running",true);
		  Assert.fail();
	  }
	  
	  @Test(groups = "regression")
	  public void TC8()
	  
	  {
		  Reporter.log("TC8 regression Running",true);
		  Assert.fail();
	  }
	  
	  @Test  (groups = "sanity")
	  public void TC9()
	  
	  {
		  Reporter.log("TC9 sanity Running",true);
	  }
	  
	  @Test
	  public void TC10()
	  
	  {
		  Reporter.log("TC10 Running",true);
	  }

}
