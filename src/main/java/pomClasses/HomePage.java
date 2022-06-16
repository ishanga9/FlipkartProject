package pomClasses;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.UtilityClass;

public class HomePage extends UtilityClass {

	WebDriver driver;
	@FindBy(xpath="//input[@type='text']")
	WebElement searchField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchSubmitButton;
	
	@FindBy(xpath="//span[text()='Cart']")
	WebElement ecart;
	
	@FindBy(xpath="(//div[@class='exehdJ'])[1]")
	WebElement profile;
	
	@FindBy (xpath="(//div[@class='_4rR01T'])[1]")
	private WebElement firstProductList;
	
	@FindBy (xpath="//div[text()='Logout']")
	WebElement logout;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void putsearchField(String searchText) throws IOException, Exception
	{
		searchField =waitFor(driver,searchField,10);
		searchField.sendKeys(searchText);
	}
	public void clicksearchSubmitButton()
	{
		searchSubmitButton.click();
	}
	public void goToCart()
	{
		waitFor(driver,ecart,10).click();
	}
	public boolean isLoginSuccessfull(WebDriver driver)
	{
		profile=waitFor(driver,profile,10);
		if(profile.getText().equals("Himank"))
			{
			return true;
			}
		else
			{
			return false;
			}
	}
	public String getProfileName()
	{
		profile=waitFor(driver,profile,60);
		String name=profile.getText();
		System.out.println("In getProfile "+name);
		return name;
	}
	
	public boolean isProductListDispalyed()
	{boolean productPresent=false;
		try
		{
		firstProductList=	waitFor(driver,firstProductList,60);
		if(firstProductList.isDisplayed())
			productPresent= true;
		
		}catch(Exception e)
		{
			e.printStackTrace();
			productPresent= false;
		}
		return productPresent;
		
	}
	public String clickProductToViewDetails() 
	{
		firstProductList.click();
		String prductText=firstProductList.getText();
		System.out.println(" Click product to view "+prductText);
		List<String> list=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		return prductText;
	}
	
	
	
	
	
	
	
	public void logout(WebDriver driver1) throws InterruptedException
	{
		try {
		Actions act=new Actions(driver1);
		profile=waitFor(driver,profile,60);
		act.moveToElement(profile).clickAndHold().build().perform();
		System.out.println(" move to profile complete : HP");
		logout=waitFor(driver1,logout,60);
		act.moveToElement(logout).click().build().perform();
		System.out.println("Logout complete :HP");
		}
		catch (Exception E)
		{
			System.out.println("Logout trace strats ================================================");
			E.printStackTrace();
			System.out.println("Logout trace ends====================================================");
		}
	}
	
}
