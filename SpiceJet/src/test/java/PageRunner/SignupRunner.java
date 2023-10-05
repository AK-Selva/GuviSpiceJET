package PageRunner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import DriverSetup.BrowserSetup;
import Pages.*;

public class SignupRunner extends BrowserSetup {
	Signup signup = null;
	String email;
	String password;
	String mobile;
	String ValidationTitle = "Create an Account";

	public void basicInfo() {
		String emailUserAcc = "guviautomation2" + generateRandomNumber(1000, 9999);
		email = emailUserAcc + "@mailinator.com";
		password = generateRandomPassword(12);
		mobile = String.valueOf(generateRandomNumber(1000000000L, 9999999999L));
	}

	@Test(priority = 1)
	public void NameTitle() throws InterruptedException, IOException {
		try {
			signup = new Signup(webDriver);
			signup.nameTitleSelection();
		} catch (Exception e) {
			// BrowserSetup.takeScreenshot(webDriver);
		}
	}

	@Test(priority = 2)
	public void Firstname() throws InterruptedException, IOException {
		try {
			signup = new Signup(webDriver);
			signup.firstname();
		} catch (Exception e) {
			// BrowserSetup.takeScreenshot(webDriver);
		}
	}

	@Test(priority = 3)
	public void lastname() throws InterruptedException, IOException {
		try {
			signup = new Signup(webDriver);
			signup.lastname();
		} catch (Exception e) {
			// BrowserSetup.takeScreenshot(webDriver);
		}
	}

	@Test(priority = 4)
	public void doB() throws InterruptedException, IOException {
		try {
			signup = new Signup(webDriver);
			signup.DateofBirth();
		} catch (Exception e) {
			// BrowserSetup.takeScreenshot(webDriver);
		}
	}

	@Test(priority = 5)
	public void Mobilenumber() throws InterruptedException, IOException {
		try {
			signup = new Signup(webDriver);
			signup.Mobilenumber();
		} catch (Exception e) {
			// BrowserSetup.takeScreenshot(webDriver);
		}
	}

	@Test(priority = 6)
	public void email() throws InterruptedException, IOException {
		try {
			signup = new Signup(webDriver);
			signup.email();
		} catch (Exception e) {
			// BrowserSetup.takeScreenshot(webDriver);
		}
	}

	@Test(priority = 7)
	public void Passwords() throws InterruptedException, IOException {
		try {
			signup = new Signup(webDriver);
			signup.passwords();
		} catch (Exception e) {
			// BrowserSetup.takeScreenshot(webDriver);
		}
	}

	@Test(priority = 8)
	public void SubmittheSignup() throws InterruptedException, IOException {
		try {
			signup = new Signup(webDriver);
			String text = signup.clickCreateAccountButton();
			System.out.println(text);
			Assert.assertEquals(text, "OTP Verification", "Register Not completed");
		} catch (Exception e) {
			// BrowserSetup.takeScreenshot(webDriver);
		}
	}

	@Test(priority = 9)
	public void closewindow() throws InterruptedException, IOException {
		try {
			signup = new Signup(webDriver);
			signup.closeoutwindow();
			String title = webDriver.getTitle();
			Assert.assertEquals(title, "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		} catch (Exception e) {
			// BrowserSetup.takeScreenshot(webDriver);
		}
	}

	
}
