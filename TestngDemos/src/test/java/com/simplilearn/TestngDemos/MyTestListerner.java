package com.simplilearn.TestngDemos;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListerner implements ITestListener{
	
	public void onStart(ITestContext context) {
		System.out.println("onstart method executed...");
	}
	
     public void onFinish(ITestContext context) {
    	 System.out.println("onFinish method executed...");
	}
     
     public void onTestFailure(ITestResult result) {
    	 System.out.println("onTestFailure method executed...Method name "+result.getName());
 	}
     
     public void onTestSkipped(ITestResult result) {
    	 System.out.println("onTestSkipped method executed...Method name "+result.getName());
  	}
     
     public void onTestStart(ITestResult result) {
    	 System.out.println("onTestStart method executed...Method name "+result.getName());
   	}
     
     public void onTestSuccess(ITestResult result) {
    	 System.out.println("onTestSuccess method executed...Method name "+result.getName());
    	}

}
