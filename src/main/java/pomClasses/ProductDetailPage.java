package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.UtilityClass;

public class ProductDetailPage extends UtilityClass {
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='B_NuCI']")
	private WebElement product;
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	private WebElement addToCart;
	
	
	public ProductDetailPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
		this.driver=driver;
	}
	
	public boolean verifySecltedProductName(String proName) {
		boolean test=false;
		if(product.getText().contains(proName))
			test=true;
		else
			test=false;
		
		return test;
	}
	
	public void addToCart()
	{
		addToCart.click();
	}
	
}
