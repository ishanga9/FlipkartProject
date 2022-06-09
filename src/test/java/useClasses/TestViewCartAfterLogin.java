package useClasses;



import org.openqa.selenium.WebDriver;


import baseClasses.BaseClass;
import pomClasses.CartPage;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import utilityClasses.UtilityClass;

public class TestViewCartAfterLogin extends UtilityClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver=BaseClass.getDriver("chrome");
		
	LoginPage lp=new LoginPage(driver);
	lp.putEmail();
	lp.putPassward();
	UtilityClass.takeScreenshot(driver,"TestViewCartAfterLogin");
	lp.clickLoginButton();
	
	Thread.sleep(3000);
	HomePage hp=new HomePage(driver);
	hp.putsearchField("Samsumg Frame");
	hp.clicksearchSubmitButton();
	Thread.sleep(3000);
	
	hp.goToCart();
	CartPage cp=new CartPage(driver);
	
	if(cp.isCartEmpty())
	{
		System.out.println("Cart is Empty");
	}
	else
	{
	UtilityClass.takeScreenshot(driver,"TestViewCartAfterLogin");
	System.out.println(cp.getTotalAmount());
	}
	
	}

}
