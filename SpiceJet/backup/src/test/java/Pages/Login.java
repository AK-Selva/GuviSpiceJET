package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	public WebDriver webDriver;
	public Login(WebDriver driver) {
		this.webDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginPage() throws InterruptedException
	{
		//webDriver.get(url);
		Thread.sleep(1000);
//		WebElement element = webDriver.findElement(By.xpath("//span[@class='v-p-right-xxs line-clamp']"));
//		element.click();
		Thread.sleep(1000);
		WebElement logoutelement = webDriver.findElement(By.xpath("//div[contains(text(),'Login')]"));
		logoutelement.click();
		
	//	return webDriver.getTitle();
	}
	public String validLoginDetails() throws InterruptedException
	{
		WebElement Mobileelement = webDriver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa'][normalize-space()='Mobile Number']"));
		Mobileelement.click();
		WebElement element = webDriver.findElement(By.xpath("//input[@data-testid='user-mobileno-input-box']"));
		element.click();
		element.sendKeys("9688075595");
		Thread.sleep(1000);
		WebElement passwordElement = webDriver.findElement(By.xpath("//input[@type='password']"));
		passwordElement.click();
		passwordElement.sendKeys("password@Cbe2023");
		Thread.sleep(5000);
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
		WebElement SubmitElement = webDriver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-184aecr r-z2wwpe r-1loqt21 r-18u37iz r-tmtnm0 r-1777fci r-1x0uki6 r-1w50u8q r-ah5dr5 r-1otgn73']"));
		SubmitElement.click();
		Thread.sleep(2000);
		return webDriver.getTitle();
	}
	public String InvalidvalidLoginDetails() throws InterruptedException
	{
		WebElement Mobileelement = webDriver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa'][normalize-space()='Mobile Number']"));
		Mobileelement.click();
		WebElement element = webDriver.findElement(By.xpath("//input[@data-testid='user-mobileno-input-box']"));
		element.click();
		element.sendKeys("9688075595");
		Thread.sleep(1000);
		WebElement passwordElement = webDriver.findElement(By.xpath("//input[@type='password']"));
		passwordElement.click();
		passwordElement.sendKeys("password@Cbe20231");
		Thread.sleep(5000);
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
		WebElement SubmitElement = webDriver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-184aecr r-z2wwpe r-1loqt21 r-18u37iz r-tmtnm0 r-1777fci r-1x0uki6 r-1w50u8q r-ah5dr5 r-1otgn73']"));
		SubmitElement.click();
		Thread.sleep(2000);
		return "Invalid";
	}
}
