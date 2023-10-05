package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.*;

public class HomePage {
	public WebDriver webDriver;

	public HomePage(WebDriver driver) {
		this.webDriver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() throws InterruptedException {
		return this.webDriver.getTitle();
	}

	public void ClickSignup() throws InterruptedException {
		WebElement Signup = webDriver.findElement(By.xpath("//div[contains(text(),'Signup')]"));
		Signup.click();
		
		 ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
		 webDriver.switchTo().window(tabs.get(1));
		 //webDriver.close();
		 //webDriver.switchTo().window(tabs.get(0));
	}

	public String checkSignupTitle() throws InterruptedException {
		String title = webDriver.getTitle();
		return title;
	}

	public String checkSignupDetails() throws InterruptedException {
		WebElement checkSignupDetails = webDriver.findElement(By.xpath("//h1[@class='title-black mb-2']"));
		return checkSignupDetails.getText();
	}

}
