package com.coverfox_Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.coverfox_Base.BaseDummy;
import com.coverfox_POM.HealthPlan;
import com.coverfox_POM.Home;
import com.coverfox_POM.GenderSelectingPage;
import com.coverfox_POM.Result;
import com.coverfox_POM.addressDetails;
import com.coverfox_POM.memberDetails;
import com.coverfox_Utility.Utility_mvn;

 @Listeners(com.coverfox_Listener.Listener.class)
public class cfTest extends BaseDummy {
	
	public static Logger logger;

	
//	GenderSelectingPage gs;
	HealthPlan hp;
	memberDetails md;
	addressDetails ad;
	Home home;
	Result res;
	
	
	@BeforeClass
	public void objInitialze() throws IOException {
		 logger= Logger.getLogger("maven_coverfox");
		  PropertyConfigurator.configure("log4j.properties");
		  logger.info("hello");
		  logger.info("this is my first change");
		  logger.info("this is my second change");

		launchBrowser();
//		 gs = new GenderSelectingPage(driver);
		 hp = new HealthPlan(driver);
		 md = new memberDetails(driver);
		 ad = new addressDetails(driver);
		 res = new Result(driver);
		 home =new Home(driver);
	}
	
	@BeforeMethod
	public void precon() throws IOException, InterruptedException {
		
		logger.info("selecting Health Plan option");
		home.selectingHealthPlan();
		
		logger.info("selecting gender");
		home.gender();
		
		logger.info("Entering mobile number");
		home.enterobilenum();
		
		logger.info("clicking View Quote Button ");
		home.clickOnViewQuoteButton();
		 
//		gs.clickOnFemaleButton();
		logger.info("Clicked on Gender button");
		
		logger.info("Clicking on next button");
		hp.clickOnNextButton_healthPlan(driver);
		
		logger.info("Entering Age");
		md.ageDropdown(Utility_mvn.readExcel("Sheet2", 1, 4));
		logger.info("Clicking on next button");
		md.clickNextButton(driver);
		
		logger.info("Entering Pincode button");
		ad.enterPincode(Utility_mvn.readExcel("Sheet2", 1, 5));
		logger.info("Entering Mobile number button");
		ad.enterMobileNum(Utility_mvn.readExcel("Sheet2", 2, 3));
		logger.info("Clicking on Continue button");
		ad.ClickOnContinueButton();
		logger.info("Getting Plan result");
		res.getplanResult();
		logger.info("getting getNumOfPlancard ");
		res.getNumOfPlancard();
		
	}

	@Test
  public void f() throws InterruptedException, IOException {
//		Assert.fail();
	int planres = res.getplanResult();
	int plancard = res.getNumOfPlancard();
	
	assertEquals(planres, plancard, "TC fail");
		
		Reporter.log("TC passed", true);
		
  }
	
	 @AfterClass
	    public void closeApplication() throws InterruptedException {

	        Thread.sleep(2000);

	        closeBrowser();
	 }
	
  }




//notes:
//@BeforeClass   -> Open browser
//
//@BeforeMethod  -> Login / precondition
//
//@Test          -> Test case
//
//@AfterMethod   -> Logout
//
//@AfterClass    -> Close browser
