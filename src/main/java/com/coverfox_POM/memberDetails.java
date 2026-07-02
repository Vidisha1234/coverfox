package com.coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class memberDetails {
	
	@FindBy(xpath = "//select[@id='Age-You']") private WebElement selectage;
	@FindBy(className = "next-btn") private WebElement nextButton;
	
	
	public memberDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void ageDropdown(String age) {
		Reporter.log("Selecting age from dropdown", true);
		Select s = new Select(selectage);
		s.selectByValue(age+"y");
		
	}
	
	public void clickNextButton(WebDriver driver) {
		Reporter.log("clicking on next Button", true);
		nextButton.click();
		
		
	}

}
