package com.coverfox_POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HealthPlan {
	
	@FindBy (className = "next-btn") private WebElement nextButton;
	
	public HealthPlan(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNextButton_healthPlan(WebDriver driver) throws IOException {
		Reporter.log("clicking on next Button", true);
		nextButton.click();
		
	}

}
