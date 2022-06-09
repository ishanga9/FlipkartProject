package useClasses;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertStudy {
	SoftAssert soft= new SoftAssert();
	
	  @Test
	  public void TC1() 
	  {
		String ExpectedResult="VCTCPune";
		String ActualResult="VCTC";
		
		soft.assertNotEquals(ActualResult, ExpectedResult, "Value is not matching");
		
		Reporter.log("TC1 softAssert is running",true);
		
		soft.assertNotNull(ActualResult);
		
		Reporter.log("running TC",true);
		soft.assertTrue(ExpectedResult.endsWith("Pune"), "String ends with pune");
		
		soft.assertAll();
		  
	  }
	  
	  

}
