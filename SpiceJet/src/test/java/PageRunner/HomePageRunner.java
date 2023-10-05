package PageRunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import DriverSetup.BrowserSetup;
import Pages.HomePage;

public class HomePageRunner extends BrowserSetup {
	HomePage navigation = new HomePage(webDriver);;

	@Test(priority=1)
	public void HomePageMenuLinks() throws InterruptedException {
		navigation = new HomePage(webDriver);

		webDriver.navigate().to(homePage);
		String PageTitle = navigation.checkSignupTitle();
		Assert.assertEquals(PageTitle, "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
	}

	@Test(priority=2)
	public void SignupClick() throws InterruptedException {
		navigation = new HomePage(webDriver);
		navigation.ClickSignup();
	   //   Thread.sleep(1000);
	}

	@Test(priority=3)
	public void ChecksignupTitle() throws InterruptedException {
		navigation = new HomePage(webDriver);
		String title = navigation.getPageTitle();
		Assert.assertEquals(title, "SpiceClub - The frequent flyer program of SpiceJet");

	}

	@Test(priority=4)
	public void checkSignupDetails() throws InterruptedException {
		navigation = new HomePage(webDriver);
		String content = navigation.checkSignupDetails();
		Assert.assertEquals(content, "Member Enrollment");

	}

}
