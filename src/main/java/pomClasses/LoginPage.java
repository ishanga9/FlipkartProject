package pomClasses;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.UtilityClass;

public class LoginPage extends UtilityClass{

	
	WebDriver driver;
	
	@FindBy (xpath="(//input[@type='text'])[2]")
	WebElement email;
	
	@FindBy (xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy (xpath="(//span[text()= 'Login' ])[2]")
	WebElement loginButton;
	
	public 	LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	this.driver=driver;	
	
	}
	public void putEmail() throws Exception
	{//akshaynarhare1541@gmail.com
		waitFor(driver,email,10).sendKeys(getPropertyFromFile("UN"));
	}
	
	public void putPassward() throws Exception
	{
	//Akshay123
		password= waitFor(driver,password,10);
		password.sendKeys(getPropertyFromFile("PWD"));
	}
	
	public void clickLoginButton()
	{
	loginButton.submit();
	}
	
}
