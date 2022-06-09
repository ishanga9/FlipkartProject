package useClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import baseClasses.BaseClass;
import pomClasses.CartPage;
import pomClasses.CheckOutPage;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import pomClasses.ProductDetailPage;
import utilityClasses.CommonExtentReporter;
import utilityClasses.ExtentReports_Exa;
import utilityClasses.UtilityClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Test_EtoE_BuyProduct extends CommonExtentReporter {
 // WebDriver driver;
  LoginPage lp;
  CartPage cp;
  HomePage hp;
  ProductDetailPage pdp;
  CheckOutPage cop;
  String Selectedproduct;
  
  
  
  
  
  
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browser1) throws InterruptedException {
	   driver=BaseClass.getDriver(browser1);
	   Reporter.log("Test_EtoE_BuyProduct  :Driver initiated. "+browser1,true);
	   test=reporter.createTest("Test_EtoE_BuyProduct");
  }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  
	    lp=new LoginPage(driver);
		hp=new HomePage(driver);
		cp=new CartPage(driver);
		pdp=new ProductDetailPage(driver);
		cop=new CheckOutPage(driver);
		
		Reporter.log("Test_EtoE_BuyProduct :Initializing Objects ",true);
		
  }
  
  @Test
    public void verifyUserCanLogin() throws Exception
  {
	    lp.putEmail();
		lp.putPassward();
		UtilityClass.takeScreenshot(driver,this.getClass().getName());
		lp.clickLoginButton();
		Thread.sleep(10000);
		Assert.assertEquals(hp.getProfileName(), "Himank","Test_EtoE_BuyProduct:Profile name is mismatch");
		Reporter.log("Test_EtoE_BuyProduct:Login is complete",true);
		
  }
  
    
  @Test(dependsOnMethods= {"verifyUserCanLogin"})
  public void verifyUserCanSearcProduct() throws Exception {
	 
	hp.putsearchField(getFromExel(0,0));
	hp.clicksearchSubmitButton();
	
	Assert.assertTrue(hp.isProductListDispalyed(),"Test_EtoE_BuyProduct: Unable to Search Product");
	Reporter.log("Test_EtoE_BuyProduct : User is able to search Product",true);
	
	Thread.sleep(6000);
	
	}
  
  @Test(dependsOnMethods= {"verifyUserCanSearcProduct"})
  public void verifyUserCanSelectProduct()
  {
	 Selectedproduct=  hp.clickProductToViewDetails();
	Assert.assertTrue(pdp.verifySecltedProductName(Selectedproduct),"Test_EtoE_BuyProduct: Product is not selected");
	Reporter.log("Test_EtoE_BuyProduct : User is able to Select Product",true);
	
  }

  @Test(dependsOnMethods= {"verifyUserCanSelectProduct"})
  public void verifyUserCanAddProductToCat()
  {
	  pdp.addToCart();
	  SoftAssert soft=new SoftAssert();
	  soft.assertTrue(cp.isOnCartPage(),"Test_EtoE_BuyProduct :Not on Cart page");
	  Reporter.log("Test_EtoE_BuyProduct : User is able to Add Product to Cart",true);
	  //calculation check to be performed -pending
	  
	  soft.assertAll();
  }
  
  @Test(dependsOnMethods= {"verifyUserCanAddProductToCat"})
  public void verifyUserCanPlaceOrder()
  {
	  Assert.assertTrue(cp.placeOrder(),"Test_EtoE_BuyProduct : User is Unable to Place order");
	  Reporter.log("Test_EtoE_BuyProduct : User is able to Place order",true);
		
  }
  
  @Test (dependsOnMethods= {"verifyUserCanPlaceOrder"})
  public void verifyUserCanSelectAddress()
  {
	  SoftAssert soft=new SoftAssert();
	  soft.assertTrue(cop.isAddressSelected(), "Test_EtoE_BuyProduct : User is unable to select his/her address");
	  Reporter.log("Test_EtoE_BuyProduct : Users is default address is selected",true);
	  soft.assertTrue(cop.clickOnDelverHere(), "Test_EtoE_BuyProduct : User is unable click Deleiver here button");
	  Reporter.log("Test_EtoE_BuyProduct : User is able click Deleiver here button",true);
	  
	  soft.assertAll();
		
  }
  
  @Test(dependsOnMethods= {"verifyUserCanSelectAddress"})
  public void verifyUserCanCheckOrderSummary()
  {
	  SoftAssert soft=new SoftAssert();
  //soft.assertTrue(cop.checkGstInvoice(), "Test_EtoE_BuyProduct : User is unable to check his/her GST Invoice");
 // Reporter.log("Test_EtoE_BuyProduct : Users is able to check his/her GST Invoice",true);
  soft.assertTrue(cop.clickOnContinue(), "Test_EtoE_BuyProduct : User is unable click Continue button");
  Reporter.log("Test_EtoE_BuyProduct : User is Unable click Continue button",true);
  
  soft.assertAll();
	 
  }
  
  @Test (dependsOnMethods= {"verifyUserCanCheckOrderSummary"})
  public void verifyUserCanConfirmOrderByCOD() throws InterruptedException
  {
	  SoftAssert soft=new SoftAssert();
  soft.assertTrue(cop.checkCOD(driver), "Test_EtoE_BuyProduct : User is unable to check COD as Payment Method");
  Reporter.log("Test_EtoE_BuyProduct : Users is able to check COD as Payment Method",true);
 
  Thread.sleep(5000);
  soft.assertTrue(cop.clickOnContinue(), "Test_EtoE_BuyProduct : User is unable click Continue button");
  Reporter.log("Test_EtoE_BuyProduct : User is Unable click Continue button",true);
  
  soft.assertAll(); 
	  
  }
  
  @AfterMethod
  public void afterMethod(ITestResult result) throws Exception {
	
	  if(result.getStatus()== ITestResult.SUCCESS)
	  {
		test.log(Status.PASS, "Test is pass "+result.getInstanceName()+" "+result.getName());
	  }
	  else
	  {
		  String path=takeScreenshot(driver,this.getClass().getName());
		  test.log(Status.FAIL, "Test is fail "+result.getInstanceName()+" "+result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			  }
	  Reporter.log("Test_EtoE_BuyProduct :After method",true);
  }

  

  @AfterClass
  public void afterClass() {
	  Reporter.log("Test_EtoE_BuyProduct :Driver closed.",true);
//	  try
//	  {
//	  driver.quit();
//	  }catch(Exception e)
//	  {}
  }
  
  

}
