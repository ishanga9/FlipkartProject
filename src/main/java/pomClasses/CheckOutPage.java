package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.UtilityClass;

public class CheckOutPage extends  UtilityClass{

	WebDriver driver;
	
	//(//input[@class='_3DAmyP'])[1]
	@FindBy(xpath="(//input[@class='_3DAmyP'])[1]")
	private WebElement selectAddress;
	
	@FindBy (xpath="//button[@class='_2KpZ6l RLM7ES _3AWRsL']")
	private WebElement deliverHereButton;
	
	@FindBy (xpath="//div[@class='_24_Dny _3cgHx8']")
	private WebElement osgstInvoice;
	
	//button[text()='CONTINUE']
	@FindBy(xpath="//button[text()='CONTINUE']")
	private WebElement osContinue;
	
	////input[@id='COD']
	@FindBy (xpath="//input[@id='COD']")
	private WebElement poCOD;
	
	@FindBy(xpath="//span[text()='Confirm Order']")
	private WebElement confirmOrder;
	
	
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
		this.driver=driver;
	}
	
	public boolean isAddressSelected()
	{
		if(selectAddress.isSelected())
			return true;
		else 
			return false;
	}
	
	public boolean clickOnDelverHere()
	{ 
			return 	clickElement(deliverHereButton);
		
	}
	
	public boolean checkGstInvoice()
	{
		//div[@class='_24_Dny _3cgHx8']
			return 	clickElement(osgstInvoice);
		
	}
	
		
	
	public boolean clickOnContinue()
	{
		return clickElement(osContinue);
	}
	public boolean checkCOD(WebDriver driver)
	{
		return scrollToViewAndClick(driver,poCOD);
	}
	
	public boolean confirmOrder()
	{
		return javaScriptEx(driver,confirmOrder);
	}
	
}
