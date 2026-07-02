package com.coverfox_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Result {

	@FindBy(xpath = "//div[contains(text(), '10 matching Health')]") private WebElement planResult;
	@FindBy(xpath = "//div[@class='pcc-details']") private List<WebElement> planCard;
	
	public Result(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public int getplanResult() {
		
		 
		String planResulttext = planResult.getText();
		String[] pr = planResulttext.split(" ");
		int result = Integer.parseInt(pr[0]);
		return result;
	}
	
	public int getNumOfPlancard() {
		Reporter.log("matching number with plan cards", true);
		int cardSize = planCard.size();
		return cardSize;
		
		
	}
	
	
	
	 
}
