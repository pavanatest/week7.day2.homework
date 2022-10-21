package hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import steps.Week7Day2BaseClass;

public class Week7Day2SalesForceHooks extends Week7Day2BaseClass {

	@Before
	public void preCondition() throws InterruptedException
	{
		//wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		// 1.  setup the path
		WebDriverManager.chromedriver().setup();
		//ChromeDriver driver=new ChromeDriver();
		
		// 2. disable notifications
		options = new ChromeOptions();
		options.addArguments("disable-notifications");
		
		// 3. create instance
		driver=new ChromeDriver(options);
				
		// 4	Launch the browser
		driver.get("https://login.salesforce.com");
		
		// 5. manage ur window
		driver.manage().window().maximize();
		
		// 6. add wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// 7. enter username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
		// 8. Enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password#123");
		
		// 9. Click login button
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		Thread.sleep(8000);
		
		// 10. Click on Global Actions SVG icon
	
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(2000);
		
		//11. click View All
		//driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//button[text()='View All']/parent::lightning-button")).click();
	}
	
	@After
	public void postCondition() throws InterruptedException
	{
		//Thread.sleep(7000);
		//driver.close();
	}
	
}
