package PageRunner;

import org.testng.annotations.Test;

import DriverSetup.BrowserSetup;
import Pages.*;

public class FlightTripsRunner extends BrowserSetup{
	Flighttrip navigation = new Flighttrip(webDriver);
	
	
	@Test(priority=1)
	public void OneWaytrip() throws InterruptedException {
		navigation = new Flighttrip(webDriver);

		webDriver.navigate().to(homePage);
		navigation.TripSelection(0);
		
	}
	@Test(priority=1)
	public void TwoWaytrip() throws InterruptedException {
		navigation = new Flighttrip(webDriver);

		webDriver.navigate().to(homePage);
		navigation.TripSelection(1);
	}
	
	
}
