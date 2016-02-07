package prac1;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import jxl.Sheet;
import jxl.Workbook;

public class contacts_grid 
{

	@Test
	@Parameters({"devicen"})
	public void testing(String dev) throws Exception
	{
		System.out.println("testing");
		WebDriver driver=null;
		DesiredCapabilities cap1=null,cap2=null;
		File myapp=new File("D:\\apps\\mycontacts.apk");
		
		if(dev.matches("lev"))
		{
			System.out.println("lenovo");
			cap1=new DesiredCapabilities();
			cap1.setCapability("device","Android");
	        cap1.setCapability("platformName", "Android");        
	        cap1.setCapability("deviceName", "Nagendra Kumar Mi (SM-"); 
	        cap1.setCapability("app",myapp.getAbsolutePath());
	        cap1.setCapability("appPackage", "com.RevoFone.renatusludos.contactmanager");  
	        cap1.setCapability("appActivity", "com.RevoFone.renatusludos.contactmanager.MyActivity");
	        driver = new AndroidDriver(new URL("http://127.0.0.1:1234/wd/hub"), cap1);
		}
		if(dev.matches("sony"))
		{
			System.out.println("sony");
			cap2=new DesiredCapabilities();
			cap2.setCapability("device","Android");
	        cap2.setCapability("platformName", "Android");        
	        cap2.setCapability("deviceName", "Xperia Z1"); 
	        cap2.setCapability("app",myapp.getAbsolutePath());
	        cap2.setCapability("appPackage", "com.RevoFone.renatusludos.contactmanager");  
	        cap2.setCapability("appActivity", "com.RevoFone.renatusludos.contactmanager.MyActivity");
	        driver = new AndroidDriver(new URL("http://127.0.0.1:1235/wd/hub"), cap2);
		}
		               
        
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.findElement(By.name("Name")).sendKeys("name1");
	    driver.findElement(By.name("Phone")).sendKeys("8989898989");
	    //((AndroidDriver)driver).hideKeyboard();
	    driver.findElement(By.name("Add Contact")).click();
	    driver.findElement(By.name("Contact List")).click();
        Thread.sleep(3000);
        driver.quit();
	}
}
