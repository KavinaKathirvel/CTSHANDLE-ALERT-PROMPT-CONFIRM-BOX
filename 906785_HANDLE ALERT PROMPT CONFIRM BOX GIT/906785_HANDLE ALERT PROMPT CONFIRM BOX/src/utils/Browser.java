package utils;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	// Create WebDriver Instance	
	WebDriver driver;
	//Creating Object of ConfigReader Class
	ConfigReader cr = new ConfigReader();
	//Assigning Values From Properties File
	String baseURL = cr.pathURL();
	String Chrome_driver_path = cr.getChrome_driver_path();
	String Firefox_driver_path = cr.getFirefox_driver_path();
	//Creating Object of Scanner Class
	Scanner sc = new Scanner(System.in);
	
	//Invoking Browser Based on User Choice
	public WebDriver invokeBrowser() throws InterruptedException 
	{
		System.out.println("Enter Browser Choice: Chrome or Firefox");
		//Get Browser of User Choice
		String browser = sc.next();
		if (browser.equalsIgnoreCase("chrome")) {
			startChromeBrowser();			
		} else if (browser.equalsIgnoreCase("firefox")) {
			startFirefoxBrowser();
		} else {
			System.out.println("Enter valid choice");
		}
		return driver;
	}
	//Launching Chrome Browser
	public WebDriver startChromeBrowser() {
		System.out.println("Launching Chrome Browser");
		String path = System.getProperty("user.dir");
		String setpath = path + Chrome_driver_path;
		System.setProperty("webdriver.chrome.driver", setpath);
		driver = new ChromeDriver();		
		//To maximize the Browser Window To Full Screen
		driver.manage().window().maximize();
		//To Wait for a certain amount of time before it throws a "No Such Element Exception"
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);		
		return driver;

	}
	//Launching FireFox Browser
	public WebDriver startFirefoxBrowser() throws InterruptedException {
		System.out.println("Launching FireFox Browser");
		String path = System.getProperty("user.dir");
		String setpath = path + Firefox_driver_path;
		System.setProperty("webdriver.gecko.driver", setpath);
		driver = new FirefoxDriver();
		//To maximize the Browser Window To Full Screen
		driver.manage().window().maximize();
		//To Wait for a certain amount of time before it throws a "No Such Element Exception"
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//driver.get(baseURL);		
		return driver;
	}
	
	//Navigate To BaseURL
	public WebDriver navigateToBaseURL() {
		
		driver.get(baseURL);
		return driver;

	}
	
	//Closing Browser
	public WebDriver closeBrowser() {
		System.out.println("Closing Browser");
		driver.quit();
		return driver;

	}

}
