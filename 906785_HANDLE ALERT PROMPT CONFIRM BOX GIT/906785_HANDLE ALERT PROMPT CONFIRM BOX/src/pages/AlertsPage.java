package pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import utils.ConfigReader;

public class AlertsPage {
	// Create WebDriver Instance	
	WebDriver driver;
	//Creating Object of ConfigReader Class
	ConfigReader cr = new ConfigReader();
	//Assigning Values From Properties File
	String switchTo = cr.getSwitchTo();
	String alerts = cr.alerts();
	String alert_Ok = cr.alert_Ok();
	String alert_Cancel = cr.alert_Cancel();
	String alert_Textbox = cr.alert_Textbox();
	String okAlert_btn = cr.okAlert_btn();
	String cancelAlert_btn = cr.cancelAlert_btn();
	String textboxAlert_btn = cr.textboxAlert_btn();
	String name = cr.getName();
	
	//Contructor of AlertsPage
	public AlertsPage(WebDriver d) {

		this.driver = d;

	}
	//Mouse Hover Action
	public void mouseHover(WebDriver driver, WebElement hoverto) {
		Actions action = new Actions(driver);
		Action mouse = action.moveToElement(hoverto).build();
		mouse.perform();
	}
	//Mouse Hover to webelement
	public void hoverToSwitchTo() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement hoverto = driver.findElement(By.linkText(switchTo));
		mouseHover(driver, hoverto);
		
	}

	//Clicks Alerts In SwithTo
	public void clickAlertsInSwithTo() {
		
		driver.findElement(By.linkText(alerts)).click();

	}
	//Clicks Alert_Ok
	public void clickAlert_Ok() {

		driver.findElement(By.linkText(alert_Ok)).click();
	}
	//Clicks Alert_Ok Button
	public void clickAlertOk_Btn() {
		
		driver.findElement(By.xpath("//button[contains(text(),'alert box:')]")).click();
	}
	//Validate Simple Alert
	public void validateAlertOk() {
		try {
			
			//getAlertsText();
			driver.switchTo().alert().accept();
			System.out.println("Simple Alert PopUp Appears\n");
			
		} catch (NoAlertPresentException e) {
			
			System.out.println("Simple Alert PopUp Not Appears\n");
			
		}

	}
	//Clicks Alert with Cancel
	public void clickAlert_Cancel() {
		
		driver.findElement(By.linkText(alert_Cancel)).click();
		
	}
	//Clicks Alert with Cancel Button
	public void clickAlertCancel_Btn() {

		driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]")).click();

	}
	//Validate Confirm Alert
	public void validate_AlertCancel() {
		try {
			
			//click cancel Button in Confirm Alert
			driver.switchTo().alert().dismiss();
			System.out.println("Confirm Alert PopUp Appears\n");
			
		} catch (NoAlertPresentException e) {
			
			System.out.println("Confirm Alert PopUp Not Appears\n");
		}

	}
	//Clicks Alert with Text Box
	public void clickAlertTextBox() {
		
		driver.findElement(By.linkText(alert_Textbox)).click();
	}
	//Clicks Alert with Text Box Button
	public void clickAlertTextBox_Btn() {
		
		driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]")).click();
	}
	
	//Validate Prompt Alert
	public void validate_AlertTextBox() {
		try {
			
			//System.out.println(driver.switchTo().alert().getText());
			Alert textbox = driver.switchTo().alert();
			//Enter User Name in prompt Alert
			textbox.sendKeys(name);
			//click Ok in alert
			textbox.accept();
			String prompttext = driver.findElement(By.id("demo1")).getText();
			String text = "Hello " + name + " How are you today";
			Assert.assertEquals(text, prompttext);
			System.out.println("Prompt Alert PopUp Appears\n");
			
		} catch (NoAlertPresentException e) {
			
			System.out.println("Prompt Alert PopUp Not Appears\n");
		}

	}

}
