package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	Properties p;

	public ConfigReader() {
	
		try {
			//Object of class FileInputStream
			FileInputStream fs;
			fs = new FileInputStream("Y:\\COGNIZANT\\906785_HANDLE ALERT PROMPT CONFIRM BOX\\src\\utils\\Config.properties");
			//Object of properties Class
			p = new Properties();	
			//load properties file
			p.load(fs);	
		
		} catch (Throwable e) {			
			e.printStackTrace();
			
		}
		

	}
	//Get SiteURL
	public String pathURL() {

		return p.getProperty("URL");
	}
	
	//Get Chrome Driver Path
	public String getChrome_driver_path() {

		return p.getProperty("CHROME_DRIVER_PATH");
	}
	
	//Get FireFox Driver Path
	public String getFirefox_driver_path() {

		return p.getProperty("FIREFOX_DRIVER_PATH");
	}	
	//Get SwitchTo LinkText Locator
	public String getSwitchTo() {
		
		return p.getProperty("SWITCH");
	}
	
	//Get Alerts LinkText Locator
	public String alerts() {

		return p.getProperty("ALERTS");
	}
	
	//Get Alert OK LinkText Locator
	public String alert_Ok() {

		return p.getProperty("ALERT_OK");
	}
	
	//Get Alert Cancel LinkText Locator
	public String alert_Cancel() {

		return p.getProperty("ALERT_CANCEL");
	}
	
	//Get Alert TextBox LinkText Locator
	public String alert_Textbox() {

		return p.getProperty("ALERT_TEXTBOX");
	}
	
	//Get Alert OK Button LinkText Locator
	public String okAlert_btn() {

		return p.getProperty("OKALERT_BTN");
	}
	
	//Get Alert Cancel LinkText Locator
	public String cancelAlert_btn() {

		return p.getProperty("CANCELALERT_BTN");
	}
	
	//Get Alert OK Button LinkText Locator
	public String textboxAlert_btn() {

		return p.getProperty("TEXTBOXALERT_BTN");
	}
	
	//Get UserName
	public String getName() {

		return p.getProperty("NAME");
	}

}
