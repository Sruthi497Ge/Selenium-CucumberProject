package testmeapps.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Utility.Casestudy2;



public class Casestudy1 {

	WebDriver driver;
	
	 
	 @Test(priority=1)
public void testRegistration()
	{
		
	
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe" );	
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("SignUp")).click();
		//String title=driver.getTitle();
		//Assert.assertTrue(title.contains("SignUp"));
		driver.findElement(By.id("userName")).sendKeys("seema29180");
		driver.findElement(By.id("firstName")).sendKeys("seema");
		driver.findElement(By.id("lastName")).sendKeys("seemaseema");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.id("pass_confirmation")).sendKeys("abc123");
		driver.findElement(By.id("gender")).click();
		driver.findElement(By.id("emailAddress")).sendKeys("seema1234@gmail.com");
		driver.findElement(By.id("mobileNumber")).sendKeys("1234567890");
		driver.findElement(By.id("dob")).sendKeys("01/01/2001");
		driver.findElement(By.id("address")).sendKeys("dassaweniooacvertyreeujhiohuhu");
		driver.findElement(By.id("securityQuestion")).sendKeys("What is your Birth Place?");
		driver.findElement(By.id("answer")).sendKeys("Pune");
		
		driver.findElement(By.cssSelector("input[value='Register']")).click();
		//boolean flag=driver.findElement(By.linkText("Register")).isDisplayed();
		//Assert.assertTrue(flag);
		//driver.findElement(By.linkText("Register")).click();
	}
		@Test(priority=2)
		public void testLogin()
		{
			
			driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		driver.findElement(By.id("userName")).sendKeys("seema29180");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		}
		/*driver.findElement(By.linkText("Login")).click();/*
		

		/*@Test(priority=4)
		public void testPayment()
		
		{
		
		}
*/		
		@Test(priority=3)
		public void testCart()
		{
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			  Actions action=new Actions(driver);
			  action.moveToElement(driver.findElement(By.partialLinkText("All Categories"))).perform();
			  action.click(driver.findElement(By.partialLinkText("Electronics"))).perform();
			  action.click(driver.findElement(By.partialLinkText("Head Phone"))).perform();
			  action.click(driver.findElement(By.partialLinkText("Add to cart"))).perform();
		}
		
		
		public void startReportBeforeTest()
		{
			driver=Casestudy2.getDriver("chrome");
			
			  driver.get("http://10.232.237.143:443/TestMeApp/");
			        driver.manage().window().maximize();
		}
		@Test
		public void endReportAfterTest()
		{
		
		}
		
		@Test
		public void getResultAfterMethod()
		{
			
		
		}
		
		
		
		
}