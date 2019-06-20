package testmeapps.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Utility.Casestudy2;

public class Login {

	WebDriver driver;
	
	@Test(priority=1)
	public void testLogin()
	{
		
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("SignIn")).click();	
	driver.findElement(By.id("userName")).sendKeys("seema29180");
	driver.findElement(By.id("password")).sendKeys("abc123");
	driver.findElement(By.cssSelector("input[value='Login']")).click();
	}
	@Test(priority=2)
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
	
	
	@Test(priority=3)
	public void testPayment()
	
	{
		  Actions action=new Actions(driver);
action.click(driver.findElement(By.partialLinkText("Cart"))).perform();
action.click(driver.findElement(By.partialLinkText("Checkout"))).perform();
action.click(driver.findElement(By.cssSelector("input[value='Proceed to Pay']"))).perform();

action.click(driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label"))).perform();
driver.findElement(By.id("btn")).click();
//action.click(driver.findElement(By.cssSelector("input[value='Continue']"))).perform();
		                          


driver.findElement(By.name("username")).sendKeys("123456");
driver.findElement(By.name("password")).sendKeys("Pass@456");
driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
driver.findElement(By.name("transpwd")).sendKeys("Trans@456\r\n" + 
		"");

driver.findElement(By.cssSelector("input[value='PayNow']")).click();

	}
	
	
}
