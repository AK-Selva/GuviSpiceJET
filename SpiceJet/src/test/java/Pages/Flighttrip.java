package Pages;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class Flighttrip {
	public WebDriver webDriver;

	public Flighttrip(WebDriver driver) {
		this.webDriver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getCurrentDay() {
		// Create a Calendar Object
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		// Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today Int: " + todayInt + "\n");
		// Integer to String Conversion
		String todayStr = Integer.toString(todayInt);
		System.out.println("Today Str: " + todayStr + "\n");
		return todayStr;
	}

	public void TripSelection(int id) {
		try {
			String texts;
			CommonDataForBooking(id);
			Thread.sleep(200);
			WebElement family = webDriver
					.findElement(By.xpath("//div[@class='css-1dbjc4n']/div[contains(text(),'Unaccompanied Minor')]"));
			family.click();

//			WebElement dummy = webDriver.findElement(By.xpath(
//					"//div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-1lgpqti'"));
//			dummy.click();
			webDriver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1L));
			Actions actions = new Actions(webDriver);
			WebElement searchFlight = webDriver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']"));
			actions.moveToElement(searchFlight).perform();
			webDriver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1L));
			// searchFlight.sendKeys(Keys.ENTER);
//			JavascriptExecutor executor = (JavascriptExecutor) webDriver;
//			executor.executeScript("arguments[0].click();", searchFlight);
//			webDriver.navigate().to("https://www.spicejet.com/search?from=MAA&to=BOM&tripType=1&departure=2023-10-15&adult=0&child=1&srCitizen=0&infant=0&currency=INR&specialCategory=UNMR&redirectTo=/");
////			
			new Actions(webDriver).moveToElement(searchFlight).click().perform();
			webDriver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1L));
			WebElement ele1 = webDriver.findElement(By.xpath(
					"//div[@class='css-1dbjc4n r-1awozwy r-1xfd6ze r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73']"));

			// Actions s = new Actions(webDriver);
//			s.moveToElement(ele1).build().perform();
//			s.contextClick();
			new Actions(webDriver).moveToElement(ele1).click().perform();

			// studentDeclation();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void studentDeclation() {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20L));
		wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath(
				"//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-f9v2oj r-1a852e4 r-1609sg0 r-1pcd2l5 r-1mdbw0j r-hnxvie']"))));
		WebElement ele = webDriver.findElement(By.xpath("//div[contains(text(),'Student Discount Bookings')]"));
		if (ele.isDisplayed()) {
			WebElement checkbox = webDriver.findElement(By.xpath("//*[name()='rect' and contains(@width,'100%')]"));
			checkbox.click();
			checkbox.sendKeys(Keys.TAB);
			checkbox.sendKeys(Keys.TAB);
			WebElement continuesubmit = webDriver.findElement(
					By.xpath("//div[@class='css-76zvg2 r-jwli3a r-1enofrn r-1kfrs79'][contains(text(),'Continue')]"));

			Actions t = new Actions(webDriver);
			t.moveToElement(continuesubmit).build().perform();
			t.clickAndHold(continuesubmit).perform();
			continuesubmit.sendKeys(Keys.ENTER);
		}
	}

	public void CommonDataForBooking(int id) throws InterruptedException {
		WebElement checboxes;
		if (id == 0) {
			checboxes = webDriver.findElement(By.xpath("//div[contains(text(),'one way')]"));
			checboxes.click();
		} else {
			checboxes = webDriver.findElement(By.xpath("//div[contains(text(),'round trip')]"));
			checboxes.click();
		}
		WebElement from = webDriver.findElement(By.xpath(
				"//div[@class='r-1862ga2 r-1loqt21 r-1enofrn r-tceitz r-u8s1d css-76zvg2'][normalize-space()='From']/following-sibling::div/input"));
		from.click();
		from.sendKeys("Chen");
		WebElement to = webDriver.findElement(By.xpath(
				"//div[@class='r-1862ga2 r-1loqt21 r-1enofrn r-tceitz r-u8s1d css-76zvg2'][normalize-space()='To']/following-sibling::div/input"));
		to.click();
		to.sendKeys("mumb");
		WebElement fromDate = webDriver.findElement(By.xpath("//div[normalize-space()='Departure Date']"));
		Thread.sleep(1000);
		fromDate.click();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,100)", "");
		if (id == 1) {
			WebElement toDate = webDriver.findElement(By.xpath("//div[normalize-space()='Return Date']"));
			Thread.sleep(1000);
			toDate.click();
			WebElement toDates = webDriver.findElement(By.xpath(
					"//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[1]/div/div[3]/div[3]/div[7]/div/div"));
			Thread.sleep(1000);
			toDates.click();
			// toDate.sendKeys(LocalDateTime.now().toString());
		}

	}

//	public void familInvalidCount() {
//		WebElement element = webDriver.findElement(By.xpath("//div[@class='css-76zvg2 css-cens5h r-jwli3a']"));
//	}
}
