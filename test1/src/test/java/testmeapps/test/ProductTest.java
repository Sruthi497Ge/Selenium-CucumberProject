package testmeapps.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;




public class ProductTest {

	@Test
	public void testProductTest1() throws InterruptedException
	
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe" );	
		WebDriver driver=new ChromeDriver();
		driver.get("http://hdfcbank.com");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
act.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products']"))).perform();
Thread.sleep(3000);
act.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards']"))).perform();
act.click(driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']"))).perform();		
		Assert.assertTrue(driver.getCurrentUrl().endsWith("credit_cards"));
		
		
	
}
}
