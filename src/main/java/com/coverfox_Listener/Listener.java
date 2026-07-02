package com.coverfox_Listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.coverfox_Base.BaseDummy;
import com.coverfox_Utility.Utility_mvn;

public class Listener extends BaseDummy implements ITestListener{
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			Utility_mvn.ss(driver, "FailedTC");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Test "+result.getName()+" is failed");
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("test "+result.getName()+" is passed");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("test "+result.getName()+" is skipped");

	}
		
		
		
		

}
