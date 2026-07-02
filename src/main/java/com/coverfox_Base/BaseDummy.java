package com.coverfox_Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.coverfox_Utility.Utility_mvn;

public class BaseDummy {
	
	protected static WebDriver driver ; //making static beacause we r using original webd in listner class so it giving nullpointexcep.
	
	public void launchBrowser() throws IOException {
		driver = new ChromeDriver();
//		driver.get("https://www.coverfox.com/");
		driver.get(Utility_mvn.readDataFromPropFile("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}
	
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
    }



