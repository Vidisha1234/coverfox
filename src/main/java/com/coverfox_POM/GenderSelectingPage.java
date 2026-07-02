package com.coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class GenderSelectingPage {
	
	@FindBy(xpath = "//div[text()='Female']") private WebElement genderButton;
	
	
	public GenderSelectingPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	public void clickOnFemaleButton() {
		Reporter.log("clicking on Gender Button", true);
		genderButton.click();
		
	}
	
	

}
