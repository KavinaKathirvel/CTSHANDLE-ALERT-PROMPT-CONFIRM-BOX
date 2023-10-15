/*Author: KAVINA K-906785
 * Module Creation Date:05/02/2021
 * Module Modification Date:05/17/2021
 * Browsers Used: Chrome,FireFox
 * Browser Versions: Chrome Version 90.0.4430.212 (Official Build) (64-bit)
 * 				   	 Firefox Version 88.0 (64-bit)
 * TestNg Versions:7.3.0
 * External Data Source :Property File
 */

package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.AlertsPage;
import utils.Browser;
import utils.ConfigReader;

public class HandlingAlerts {
	// Create WebDriver Instance
	static WebDriver driver;
	// Creating Object of Browser Class
	static Browser b = new Browser();
	
	// Creating Object of ConfigReader Class
	static ConfigReader cr = new ConfigReader();
	// Creating Object of AlertsPage Class
	static AlertsPage ap;
	// Creating Object of HandlingAlerts Class
	
	@BeforeSuite
	public void invoke_Browser() throws InterruptedException {
		
		
		
		//invoking Bowser
		HandlingAlerts.driver = b.invokeBrowser();
		//Navigate to Base Url
		b.navigateToBaseURL();
	}

	@Test(priority=0)
	public void hover_to_aletspage() {

		ap = new AlertsPage(driver);
		ap.hoverToSwitchTo();
		ap.clickAlertsInSwithTo();
	}

	// HANDLING SIMPLE ALERT
	@Test(priority=1)
	private void handle_alertWithOK() {
		ap = new AlertsPage(driver);
		System.out.println("SIMPLE ALERT");
		ap.clickAlert_Ok();
		ap.clickAlertOk_Btn();
		ap.validateAlertOk();
	}

	// HANDLING CONFIRM ALERT
	@Test(priority=2)
	private void handle_alertWithCancel() {
		ap = new AlertsPage(driver);
		System.out.println("CONFIRM ALERT");
		ap.clickAlert_Cancel();
		ap.clickAlertCancel_Btn();
		ap.validate_AlertCancel();
	}

	// HANDLING PROMPT ALERT
	@Test(priority=3)
	private void handle_alertWithPrompt() {
		ap = new AlertsPage(driver);
		System.out.println("PROMPT ALERT");
		ap.clickAlertTextBox();
		ap.clickAlertTextBox_Btn();
		ap.validate_AlertTextBox();
	}
	@AfterSuite
	public void close_Browser() {
		b.closeBrowser();
	}
}
