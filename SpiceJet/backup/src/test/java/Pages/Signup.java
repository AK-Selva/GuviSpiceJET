package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import DriverSetup.BrowserSetup;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class Signup {
	public WebDriver webDriver;
public WebDriverWait wait;
	@FindBy(xpath = "//div[@class='col-sm-4 mt-2 px-sm-4']//select[contains(@class,'form-control form-select')]")
	public WebElement name_title;

	@FindBy(xpath = "//button[@type='button'][contains(text(),'Submit')]")
	public WebElement account_create_button;

	@FindBy(xpath = "//input[@id='first_name']")
	public WebElement firstNameTextBox;

	@FindBy(xpath = "//input[@id='last_name']")
	public WebElement lastNameTextBox;

	@FindBy(xpath = "//select[@class='form-control form-select']")
	public WebElement countryname;

	@FindBy(xpath = "//input[@id='dobDate']")
	public WebElement DOB;

	@FindBy(xpath = "//div[@class=' react-tel-input']/input")
	public WebElement phoneTextBox;

	@FindBy(xpath = "//input[@id='email_id']")
	public WebElement emailTextBox;

	@FindBy(xpath = "//input[@id='new-password']")
	public WebElement pwdTextBox;

	@FindBy(xpath = "//input[@id='c-password']")
	public WebElement reenterPasswordTextBox;

	@FindBy(xpath = "//input[@id='defaultCheck1']")
	public WebElement agreeCheckBox;

	@FindBy(xpath = "//body/div[@id='react-root']/div/div/div[@class='container']/div[@class='box-full']/div[@class='row']/div[@class='register-form col-12 col-xl-7 col-lg-8']/div[1]/div[1]")
	public List<WebElement> errorMessages;
//@FindBy(xpath = "//div[@class='tb-validation']")
//public WebElements totalErrors;

	public Signup(WebDriver driver) {
		this.webDriver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() throws InterruptedException {
		return BrowserSetup.getPageTitle();
	}

	public void nameTitleSelection() {
		if (name_title.isDisplayed()) {

			Select s = new Select(name_title);
			s.selectByVisibleText("Mr");
			WebElement o = s.getFirstSelectedOption();
			System.out.println(o.getText());
		}
		// return null;
	}

	public void firstname() {
		if (firstNameTextBox.isDisplayed()) {
			firstNameTextBox.click();
			firstNameTextBox.clear();
			firstNameTextBox.sendKeys("FirstNameRegister");
		}
	}

	public void lastname() {
		if (lastNameTextBox.isDisplayed()) {
			lastNameTextBox.click();
			lastNameTextBox.clear();
			lastNameTextBox.sendKeys("LastNameRegister");
		}
	}

	public void DateofBirth() {

		if (DOB.isDisplayed()) {
			DOB.click();
			DOB.clear();
			DOB.sendKeys("1996-07-11");
			DOB.sendKeys(Keys.ESCAPE);
			DOB.sendKeys(Keys.ESCAPE);
		}
	}

	public void Mobilenumber() throws InterruptedException {
		// phoneTextBox.sendKeys(Keys.ESCAPE);
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,600)", "");
		wait= new WebDriverWait(webDriver,Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOf(phoneTextBox));
		// if(phoneTextBox.isDisplayed())
		{
			phoneTextBox.clear();
			phoneTextBox.click();
			Thread.sleep(5000);
			// js.executeScript("arguments[0].value='+919874563211';",phoneTextBox);
			phoneTextBox.sendKeys("9874563211");
			Thread.sleep(5000);
			Actions actions = new Actions(webDriver);
			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(5000);
		}
	}

	public void email() throws InterruptedException {
		if (emailTextBox.isEnabled()) {
			emailTextBox.clear();
			emailTextBox.click();
			emailTextBox.sendKeys("testinguser11212@gmail.com");
			Actions actions = new Actions(webDriver);
			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(5000);
		}
	}

	public void passwords() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,600)", "");

//		//if(phoneTextBox.isDisplayed())
		{
			pwdTextBox.clear();
			pwdTextBox.click();
			pwdTextBox.sendKeys("password@Cbe2023");
			reenterPasswordTextBox.clear();
			reenterPasswordTextBox.click();
			reenterPasswordTextBox.sendKeys("password@Cbe2023");
			reenterPasswordTextBox.sendKeys(Keys.TAB);
		}
	}

	
	public String clickCreateAccountButton() {
		if(!agreeCheckBox.isSelected())
		{
			agreeCheckBox.click();
		}
		//if (account_create_button.isDisplayed()) {
		account_create_button.sendKeys(Keys.TAB);
		account_create_button.sendKeys(Keys.TAB);
			account_create_button.sendKeys(Keys.ENTER);
			WebElement element =webDriver.findElement(By.xpath("//*[@class='modal-red-title mb-2']"));
			String text=element.getText();
			return text;
		//}

	}
	public void closeoutwindow()
	{
		 ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
		 webDriver.switchTo().window(tabs.get(1));
		 webDriver.close();
		 webDriver.switchTo().window(tabs.get(0));
	}

	public int getErrorCount() {
		List<WebElement> elements = webDriver.findElements(By.xpath("//div[@class='tb-validation']"));
		int elementsCount = elements.size();
		return elementsCount;
	}

	public List<String> invalidFirstName() throws InterruptedException {
		firstNameTextBox.click();
		Thread.sleep(1000);
		firstNameTextBox.sendKeys("Test" + (1000));
		Thread.sleep(1000);
		clickCreateAccountButton();
		List<String> invalidName = new ArrayList<>();
		invalidName.add(errorMessages.get(0).getText());
		return invalidName;
	}

	public List<String> invalidLastName() throws InterruptedException {
		lastNameTextBox.click();
		Thread.sleep(1000);
		lastNameTextBox.sendKeys("Test" + (1000));
		Thread.sleep(1000);
		clickCreateAccountButton();
		List<String> invalidName = new ArrayList<>();
		invalidName.add(errorMessages.get(0).getText());
		return invalidName;
	}

	public void validEmailandRegisterForm(String email) throws InterruptedException {
		// webDriver.navigate().refresh();
		Thread.sleep(1000);
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		// this.email = email;
		Thread.sleep(1000);
		clickCreateAccountButton();
		Thread.sleep(1200);
	}

	public void validAllFields(String email, String pwd, String cpwd, String mobile) throws InterruptedException {
		Thread.sleep(5000);
		firstNameTextBox.click();
		Thread.sleep(5000);
		firstNameTextBox.sendKeys("firstname");
		Thread.sleep(5000);
		lastNameTextBox.click();
		Thread.sleep(5000);
		lastNameTextBox.sendKeys("lastname");
		Thread.sleep(5000);
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		// this.email = email;
		Thread.sleep(5000);
		pwdTextBox.click();
		Thread.sleep(5000);
		pwdTextBox.sendKeys(pwd);
		Thread.sleep(5000);
		reenterPasswordTextBox.click();
		Thread.sleep(5000);
		reenterPasswordTextBox.sendKeys(pwd);
		validmobilenumber(mobile);
	}

	public void validfNamelNameEmail(String email) throws InterruptedException {
		firstNameTextBox.click();
		Thread.sleep(1000);
		firstNameTextBox.sendKeys("firstname");
		Thread.sleep(1000);
		lastNameTextBox.click();
		Thread.sleep(1000);
		lastNameTextBox.sendKeys("lastname");
		Thread.sleep(1000);
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		// this.email = email;
		Thread.sleep(1000);
		clickCreateAccountButton();

	}

	public void PwdandCpwd(String pwd, String cpwd) throws InterruptedException {
		pwdTextBox.click();
		Thread.sleep(1000);
		pwdTextBox.sendKeys(pwd);
		Thread.sleep(1000);
		reenterPasswordTextBox.click();
		Thread.sleep(1000);
		reenterPasswordTextBox.sendKeys(pwd);
		clickCreateAccountButton();
		Thread.sleep(1200);
	}

	public void validmobilenumber(String mobile) throws InterruptedException {
		phoneTextBox.click();
		Thread.sleep(1000);
		phoneTextBox.sendKeys(mobile);
		clickCreateAccountButton();
		Thread.sleep(1200);
	}

	public boolean AlreadyExistsVisible() {
		WebElement element = webDriver
				.findElement(By.xpath("//strong[contains(text(),'An account with this email already exists.')]"));
		if (element.isDisplayed())
			return true;
		return false;
	}
}
