package testmeapps.test;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.Test;
	
	
	public class NewTest1 {
	
		@Test
		public void testDragAndDrop() throws InterruptedException
		{
			System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
			driver.manage().window().maximize();
			WebElement from=driver.findElement(By.xpath
			("//div[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
			WebElement to=driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));	
			Actions act=new Actions(driver);
			act.dragAndDrop(from,to).perform();
			//act.clickAndHold(from).release(to).perform();
			//Thread.sleep(10000);
			WebDriverWait wait=new WebDriverWait(driver,50);
			wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id
					("ctl00_ContentPlaceholder1_Label1"), 
					"Drop a package here to check price"));
			WebElement price=driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1"));
			String priceValue=price.getText();
			System.out.println("Price value :" +priceValue);
			Assert.assertTrue(priceValue.contains("$3999"));
		}

	}



