package PageRunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import DriverSetup.BrowserSetup;
import Pages.*;

public class LoginRunner extends BrowserSetup {

	@Test(priority = 1)
	public void loginPage() throws InterruptedException {
		Login s = new Login(webDriver);
		 s.loginPage();
	}
	//@Test(priority = 2)
	public void validLoginDetailsInvalid() throws InterruptedException {
		Login s = new Login(webDriver);
		String url = s.validLoginDetails();
		if (url.equals("SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets")) {
			Assert.assertTrue(true);
			System.out.println("signin Success");
		} else
			Assert.assertTrue(false);
	}
	@Test(priority = 3)
	public void validLoginDetails() throws InterruptedException {
		Login s = new Login(webDriver);
		String url = s.validLoginDetails();
		if (url.equals("Invalid")) {
			Assert.assertTrue(true);
			System.out.println("signin Failed");
		} else
			Assert.assertTrue(false);
	}
}
