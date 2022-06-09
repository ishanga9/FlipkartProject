package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.UtilityClass;

public class CartPage extends UtilityClass{
	WebDriver driver;
	@FindBy (xpath="//div[text()='Your cart is empty!']")
	WebElement emptyCart;
	
	@FindBy(xpath="//div[@class='_3LxTgx']")
	WebElement total;
	
	@FindBy (xpath="//div[@class='exehdJ']")
	WebElement profile;
	
	////span[text()='Place Order']
	@FindBy (xpath="//span[text()='Place Order']")
	WebElement placeOrderButton;
	
	@FindBy (xpath="//div[text()='Logout']")
	WebElement logout;
	
	public CartPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
		
	}
	
	public boolean isCartEmpty()
	{
		
		try
		{emptyCart =waitFor(driver,emptyCart,60);
			System.out.println(emptyCart.getText());
			return true;
		}catch(Exception e)
		
		{
		return false;
		}
	}
	public String getTotalAmount()
	{
		total=waitFor(driver,total,10);
		return total.getText();
	}
	
	public boolean isOnCartPage()
	{
		if(placeOrderButton.isDisplayed())
			return true;
		else
			return false;
	}
	
	public boolean placeOrder()
	{boolean pOrder=false;
	try {
		placeOrderButton.click();
		pOrder=true;
	}catch(Exception e)
	{
		pOrder=false;	
	}
	return pOrder;
	}
	public void logout(WebDriver driver1) throws InterruptedException
	{
		Actions act=new Actions(driver1);
		System.out.println("In logout CP");
		profile=waitFor(driver1,profile,10);
		act.moveToElement(profile).click().build().perform();
		//build().perform();
		//logout=waitFor(driver,logout,10);
		//profile.click();
		System.out.println(" move to profile complete");
		act.moveToElement(logout).click().build().perform();
		
		System.out.println("Logout complete");
	}
}







