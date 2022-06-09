package useClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClasses.BaseClass;
import pomClasses.CartPage;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import utilityClasses.UtilityClass;

public class Test_CheckLogin_Backup extends UtilityClass{
	  private WebDriver driver;
	  CartPage cp;
	  HomePage hp;

	@Test
	  public void viewCart() throws Exception {
		 hp=new HomePage(driver);
		hp.putsearchField(getFromExel(0,0));
		hp.clicksearchSubmitButton();
		SoftAssert soft=new SoftAssert();
		
		
		Thread.sleep(6000);
		
		hp.goToCart();
		cp=new CartPage(driver);
		soft.assertTrue(!cp.isCartEmpty());
			
		UtilityClass.takeScreenshot(driver,this.getClass().getName());
		Reporter.log("Test_IsCartEmpty : "+cp.getTotalAmount(),true);
		//System.out.println(cp.getTotalAmount());
		soft.assertAll();
		}

	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  
		  LoginPage lp=new LoginPage(driver);
			lp.putEmail();
			lp.putPassward();
			UtilityClass.takeScreenshot(driver,this.getClass().getName());
			lp.clickLoginButton();
			Reporter.log("Test_IsCartEmpty :Login is complete",true);
			Thread.sleep(3000);
	  }

	  @AfterMethod
	  public void afterMethod() throws InterruptedException {
		System.out.println("Calling log out");
		  hp.logout(driver);
		 // driver.navigate().to("https://www.flipkart.com/");
		  Reporter.log("Test_IsCartEmpty :After method",true);
	  }

	  @Parameters("browser")
	  @BeforeClass
	  public void beforeClass(String browser1) throws InterruptedException {
		   driver=BaseClass.getDriver(browser1);
		   Reporter.log("Test_IsCartEmpty :Driver initiated. "+browser1,true);
	  }

	  @AfterClass
	  public void afterClass() {
		  Reporter.log("Test_IsCartEmpty :Driver closed.",true);
		  try
		  {
		  driver.quit();
		  }catch(Exception e)
		  {}
	  }

	}
