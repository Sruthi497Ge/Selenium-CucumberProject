package testmeapps.test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAppAbotUs {
	
	
	WebDriver driver;
	@Test(priority=1)
	public void testMeAPPTest1()
	{
		
		
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe" );	
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.partialLinkText("AboutUs"))).perform();
		act.moveToElement(driver.findElement(By.partialLinkText("Our Offices"))).perform();
		act.click(driver.findElement(By.partialLinkText("Chennai"))).perform();
			String title=driver.getTitle();
			System.out.println(title);

			Set<String> windows=driver.getWindowHandles();//return all the window instances
			Object[] objects=windows.toArray();
			driver.switchTo().window(objects[1].toString());
			/*
			 * for(String s:windows){driver.switchTo().window(s);}
			 */
			String title2=driver.getTitle();
			System.out.println(title2);
			driver.switchTo().frame(driver.findElement(By.name("main_page")));
			WebElement address=driver.findElement(By.id("demo3"));
			String addressvalue=address.getText();
			System.out.println(addressvalue);
			Assert.assertTrue(addressvalue.contains("Chennai"));
			driver.switchTo().window(objects[0].toString());
			//driver.close();
			driver.quit();
			
			
			
	
	
	}
}
