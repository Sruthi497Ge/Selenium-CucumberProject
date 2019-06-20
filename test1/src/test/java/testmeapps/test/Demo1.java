package testmeapps.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo1 {
	
	@Test
	public void testDemo1()
	{
		
		
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe" );	
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Google apps")).click();

}
}
