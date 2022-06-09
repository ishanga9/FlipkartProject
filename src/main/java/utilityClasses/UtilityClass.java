package utilityClasses;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass {

	public static String takeScreenshot(WebDriver driver,String cName) throws Exception
	{
		Date date=new Date();
		SimpleDateFormat adf=new SimpleDateFormat("YYYY-MM-dd-hh-mm-ss");
		String name=adf.format(date);
		String path="screenshotImages\\"+cName+"_"+ name+".png";
		TakesScreenshot shot=(TakesScreenshot)driver;
		File source=shot.getScreenshotAs(OutputType.FILE);
		
		File dest=new File(path);
		FileHandler.copy(source, dest);
		return path;
	}
	
	public static WebElement waitFor(WebDriver driver,WebElement ele,int ti)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ti));
		ele =wait.until(ExpectedConditions.visibilityOf(ele));
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
		return ele;
	}
	
	public static String getPropertyFromFile(String key) throws IOException
	{
		
		Properties pr=new Properties();
		FileInputStream file=new FileInputStream("src//main//resources//Documents//credentials.properties");
		pr.load(file);
				String value=pr.getProperty(key);
				return value;
	}
	
	public static String getFromExel(int row,int col) throws Exception, IOException
	{
		String value=null;
		File file=new File("src//main//resources//Documents//Products.xlsx");
		FileInputStream fread =new FileInputStream(file);
		Workbook book=WorkbookFactory.create(fread);
		Sheet sheet=book.getSheet("savesoil");
		value=sheet.getRow(row).getCell(col).getStringCellValue();
		fread.close();
		return value;
		
	}
	
	public static boolean javaScriptEx(WebDriver driver,WebElement ele)
	{
		boolean Here=false;
		try {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele);
		Here=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Here=false;
		}
		return Here;
	}
	
	public static  boolean scrollToViewAndClick(WebDriver driver,WebElement ele)
	{
		//js.executeScript("arguments[0].scrollIntoView(true);",ele);
		
		boolean Here=false;
		try {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
		ele.click();
		Here=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Here=false;
		}
		return Here;
	}
	
	public static boolean clickElement(WebElement ele)
	{
			//div[@class='_24_Dny _3cgHx8']
				
			boolean deliverHere=false;
			try {
				ele.click();
			deliverHere=true;
		    }
			catch(Exception e)
			{
				e.printStackTrace();
				deliverHere=false;
			}
			return deliverHere;
		}
	public static String screenshotRobot(String cName)
	{
		Date d =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd-hh-mm-ss");
		String name=sdf.format(d);
		String path=cName+".png";
		try {Thread.sleep(2000);
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		    ImageIO.write(image, "png", new File(path));
		  System.out.println("In remote");
		}
		catch(Exception f)
		{
			f.printStackTrace();
		}
		return path;
	}
	
}
















