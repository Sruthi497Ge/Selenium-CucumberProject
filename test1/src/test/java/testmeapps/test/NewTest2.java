package testmeapps.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NewTest2 {
	@Test
	public void testKeyStrokes()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();
		WebElement search=driver.findElement(By.id("myInput"));
		Actions actions=new Actions(driver);
		actions.keyDown(search,Keys.SHIFT).perform();
		actions.sendKeys("b").pause(3000).keyUp(Keys.SHIFT).sendKeys("a").pause(3000).sendKeys("g").perform();
		//actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Hand bag')]"))).click().perform();
	}

}
