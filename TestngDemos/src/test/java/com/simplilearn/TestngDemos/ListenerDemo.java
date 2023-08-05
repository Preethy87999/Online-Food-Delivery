package com.simplilearn.TestngDemos;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ListenerDemo {

	String message = "Welcome";
	
	@Test
	public  void testCase1() {
		System.out.println("it must pass");
		AssertJUnit.assertEquals(message, "Welcome");
	}
	
	@Test
	public  void testCase2() {
		System.out.println("it must fail");
		AssertJUnit.assertEquals(message, "Hi");
	}
	
	@Test
	public  void testCase3() {
		System.out.println("it must skip");
		throw new SkipException("Skipping the Test Cases 3");
		
	}
}
