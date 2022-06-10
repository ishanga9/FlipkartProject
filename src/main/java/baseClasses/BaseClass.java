package baseClasses;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public BaseClass()
	{}
	public static WebDriver getDriver(String browser) throws InterruptedException
	{WebDriver driver=null;
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.crome.driver", "src\\main\\resources\\Browser\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//added comment for 60sec implecit wait
			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Thread.sleep(3000);
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			//System.setProperty("webdriver.edge.driver", "src\\main\\resources\\Browser\\chromedriver.exe\"");
			driver=new EdgeDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(3000);
		}else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(3000);
		}
		
		return driver;
		
	}
}
