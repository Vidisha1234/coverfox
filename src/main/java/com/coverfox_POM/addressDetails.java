package com.coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class addressDetails {
	
	@FindBy(xpath = "//input[@class='mp-input-text']")private WebElement pincode;
	@FindBy(xpath = "//input[@id='want-expert']")private WebElement number;
	@FindBy(xpath = "//div[text()='Continue']")private WebElement ContinueButton;
	public addressDetails (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterPincode( String pin) {
		Reporter.log("Entering pincode", true);
		pincode.sendKeys(pin);
	}
	
	public void enterMobileNum(String mobileNum) {
		Reporter.log("Entering mobile number", true);
		number.sendKeys(mobileNum);
		
	}
	public void ClickOnContinueButton() {
		Reporter.log("clicking on continue Button", true);
		ContinueButton.click();
		
	}
    }
