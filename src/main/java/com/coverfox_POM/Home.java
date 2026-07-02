package com.coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	@FindBy(xpath = "//li[text()='Health']") private WebElement selectingPlan;
    @FindBy(xpath = "//div[text()='Female']") private WebElement selectingGender;
    @FindBy(xpath = "//input[@type='tel'][1]") private WebElement number;
    @FindBy(xpath = "//button[text()='View Quotes']") private WebElement quoteButton;

public Home(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
	
}

public void selectingHealthPlan() {
	
	selectingPlan.click();
	
}
public void gender() {
	selectingGender.click();
	
}

public void enterobilenum (){
	selectingGender.click();
	number.sendKeys("8888888888");
	
	
}

public void clickOnViewQuoteButton() {
	quoteButton.click();
	
}

}