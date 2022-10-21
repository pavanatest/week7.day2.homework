package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Week7Day2SalesForceSteps extends Week7Day2BaseClass {
	
	
	@And("Click Sales")
	public void clickSales() throws InterruptedException
	{
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);
	}
	
	@And("Click on Opportunity tab")
	public void clickOppurtunityTab() throws InterruptedException
	{
		WebElement opp = driver.findElement(By.xpath("(//a[@class='slds-context-bar__label-action dndItem'])[2]"));
		driver.executeScript("arguments[0].click()", opp);
		Thread.sleep(5000);
	}
	
	@And("Click on New button")
	public void clickNewButton()
	{
		driver.findElement(By.xpath("//div[text()='New']")).click();
	}
	
	@And("Enter account name as {string}")
	public void enterAccountName(String accountName) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(accountName);
		Thread.sleep(3000);
	}
	
	
	@And("Choose close date")
	public void chooseCloseDate() 
	{
		WebElement closeDate = driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']"));
		closeDate.click();
		closeDate.sendKeys("10/18/2022");
	}
	
	@And("Click stage as Need Analysis")
	public void clickStage() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[contains(@class,'slds-input_faux')]")).click();
		//driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input-value')]")).click();
		Thread.sleep(3000);
		
		WebElement stageEle = driver.findElement(By.xpath("(//lightning-icon[@class='slds-input__icon slds-input__icon_right slds-icon-utility-down slds-icon_container'])[1]"));
		driver.executeScript("arguments[0].click()", stageEle);
		WebElement findElement2 = driver.findElement(By.xpath("(//span[@class='slds-media__body'])[4]/span"));
		driver.executeScript("arguments[0].click();", findElement2);
		Thread.sleep(9000);
	}
	
	@And("Click save button")
	public void clickSaveButton()
	{
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	}
	
	@Then("Verify Oppurtunity Name")
	public void verifyOppurtunityName()
	{
		String nameVerify = driver.findElement(By.xpath("(//a[@class='forceActionLink'])[2]")).getAttribute("title");
		System.out.println("Opportunity name is "+nameVerify);
		
		if(nameVerify.contains("QA"))
		{
			System.out.println("Opportunity name is verified");
		}
		else
		{
			System.out.println("Opportunity name is not verified");
		}
	}
	
	@And("Send close date as {string}")
	public void sendCloseDateAs(String closeDate)
	{
	WebElement closeEle= driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']"));
	closeEle.click();
	closeEle.sendKeys(closeDate);
	}
	
	@Then("Verify the Alert message displayed for Name and Stage")
	public void verifyAlertMessage()
	{
		String field = driver.findElement(By.xpath("//div[@class='genericNotification']/strong")).getText();
		System.out.println("Error Message :"+field);
		
		String field1 = driver.findElement(By.xpath("//ul[@class='errorsList slds-list_dotted slds-m-left_medium']/li/a")).getText();
		System.out.println(field1);
		String field2 = driver.findElement(By.xpath("(//ul[@class='errorsList slds-list_dotted slds-m-left_medium']/li/a)[2]")).getText();
		System.out.println(field2);
		
	}
	
	@And("Click on Dashboards")
	public void clickDashboards() throws InterruptedException
	{
		WebElement dashBoard = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		driver.executeScript("arguments[0].click()",dashBoard);
		Thread.sleep(5000);
	}
	
	@And("Click on the new dashboard")
	public void clickNewDashboard() throws InterruptedException
	{
		WebElement newDashBoard = driver.findElement(By.xpath("//div[@title='New Dashboard']"));
		driver.executeScript("arguments[0].click()",newDashBoard);
		Thread.sleep(5000);
	}
	
	@And("Enter name as {string}")
	public void enterSalesforceAutomation(String nameValue) throws InterruptedException
	{
		WebElement nameFrame = driver.findElement(By.xpath("//div[@class='dashboardContainer']/iframe"));
		driver.switchTo().frame(nameFrame);
		WebElement nameEle = driver.findElement(By.xpath("//div[@class='slds-form-element__control']/input"));
		Thread.sleep(2000);
		nameEle.sendKeys(nameValue);
		Thread.sleep(5000);
		givenName = nameEle.getAttribute("value");
	}
	
	@And("click Create")
	public void clickCreate() throws InterruptedException
	{
				
		WebElement createEle= driver.findElement(By.xpath("//button[text()='Create']"));
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(createEle));
		
		driver.executeScript("arguments[0].click()",createEle);
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
				
	}
	
	
	@Then("Verify the Dashboard name")
	public void verifyDashboardName() throws InterruptedException
	{
		WebElement frameEle1 = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		
		driver.switchTo().frame(frameEle1);
		Thread.sleep(2000);
		
		WebElement verifyEle = driver.findElement(By.xpath("//span[@class='slds-form-element__static slds-grid slds-grid_align-spread']"));
		String displayName = verifyEle.getText();
		System.out.println("Display Dashboard name :"+displayName);
		Thread.sleep(3000);
		
		if(displayName.contains(givenName))
			System.out.println("Dashboard verified");
		else
			System.out.println("Dashboard not verified");
		
		driver.switchTo().defaultContent();
		//wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		
	}
	
	@And("Click Individuals from App Launcher")
	public void clickIndividuals()
	{
		WebElement individuals = driver.findElement(By.xpath("//p[text()='Individuals']"));
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(individuals));
		
		driver.executeScript("arguments[0].click()",individuals);
		//Thread.sleep(5000);
	}
	
	@And("Click on the Dropdown icon in the Individuals tab")
	public void clickOnDropDownInIndividuals() throws InterruptedException
	{
		WebElement dropEle = driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[14]/lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container']"));
		dropEle.click();
		Thread.sleep(4000);
		
		WebElement dropEle2 = driver.findElement(By.xpath("//lightning-icon[@class='slds-icon-text-default slds-m-right--x-small slds-shrink-none slds-icon-utility-add slds-icon_container']"));
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dropEle2));
		
		driver.executeScript("arguments[0].click()", dropEle2);
		
		//Thread.sleep(8000);
	}
	
	
	@And("Enter Salutation as Mr")
	public void enterSalutation() throws InterruptedException
	{
		
		WebElement salutationEle = driver.findElement(By.xpath("//div[@class='uiPopupTrigger']"));
		salutationEle.click();
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//li[@class='uiMenuItem uiRadioMenuItem']//a[@title='Mr.']")).click();
	}
	
	
	
	@And("Enter LastName as {string}")
	public void enterLastName(String lastName) throws InterruptedException
	{
		
		WebElement lName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lName.click();
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(lName));
		
		lName.sendKeys(lastName);
		Thread.sleep(4000);
		givenIndividual = lName.getAttribute("value");
		Thread.sleep(3000);
		
	}
	
	@And("Click Save")
	public void clickSave() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		Thread.sleep(4000);
	}
	
	@Then("Verify individuals")
	public void verifyIndividuals() throws InterruptedException
	{
		String displayIndividual = driver.findElement(By.xpath("//div[@class='slds-align-middle slds-hyphenate']//span")).getText();
		System.out.println("Display Individual :"+displayIndividual);
		Thread.sleep(3000);
	
		
		if(displayIndividual.contains(givenIndividual))
			System.out.println("Individual matched");
		else
			System.out.println("Individual not matched");
		
		Thread.sleep(2000);
		
	}
	
	@And("Click on Accounts tab") 
	public void clickOnAccountsTab()
	{
		WebElement opp = driver.findElement(By.xpath("(//a[@class='slds-context-bar__label-action dndItem'])[6]"));
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(opp));
		driver.executeScript("arguments[0].click()", opp);
		//Thread.sleep(5000);
	}
	
	@And("Enter Account name as {string}")
	public void enterAccName(String yourName)
	{
		WebElement accName = driver.findElement(By.xpath("//input[@name='Name']"));
		accName.sendKeys(yourName);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(accName));
		//Thread.sleep(6000);
		name = driver.findElement(By.xpath("//input[@name='Name']")).getAttribute("value");
		System.out.println("Given name :"+name);
	}
	
	@And("Select Ownership as Public")
	public void selectOwnership() throws InterruptedException
	{
		driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]")).click();
		
		WebElement triIcon = driver.findElement(By.xpath("(//lightning-icon[@class='slds-input__icon slds-input__icon_right slds-icon-utility-down slds-icon_container'])[3]"));
		//Thread.sleep(5000);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(triIcon));
		driver.executeScript("arguments[0].click()", triIcon);
		Thread.sleep(3000);
		
		
		WebElement pub = driver.findElement(By.xpath("//span[@class='slds-media__body']/span[@title='Public']"));
		//pub.click();
		wait.until(ExpectedConditions.elementToBeClickable(pub));
		driver.executeScript("arguments[0].click()", pub);
		//Thread.sleep(2000);
	}
	
	@Then("Verify Account name")
	public void verifyAccountName() throws InterruptedException
	{
		String displayName = driver.findElement(By.xpath("((//a[@class='forceActionLink'])/div)[7]")).getAttribute("title");
		System.out.println("Display name :"+displayName);
		Thread.sleep(4000);
					
		if(displayName.contains(name))
			System.out.println("Name is verified");
		else
			System.out.println("Name is not verified");
	}
	
	
	
	
	}
		
	

